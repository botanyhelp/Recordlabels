### Android Record Labels App README

This file discusses how to create the Recordlabels Android 
application currently on Google Play.  Most of this README 
discusses the imperfect creation of the SQLite database from 
the record label data file.  That data file was mined from 
wikipedia by someone else.  The Java source code used to 
create the app is not discussed much here.  Knowledge of 
python, linux, sqlite, java and android will help reading. 

Long ago found here: infochimps.com/datasets/ was a file with this data in this file:
```
md5sum infobox_infobox_record_label.yaml
```
**4f87052c25201416dcddb7ed57a66dd3  infobox_infobox_record_label.yaml**

That file can be turned into a file of SQL insert statements 
with a python2 program
```{bash}
vim LabelReader.py
```
which reads, like this **cat LabelReader.py**:
```{python}
from __future__ import print_function
import yaml
import re

stram = open("infobox_infobox_record_label.yaml", "r")
docs = yaml.load_all(stram)
for doc in docs:
    for k,v in doc.items():
        print("INSERT INTO labels (", end='')
        columns = "label, "
        values = "'" + k + "', '"
        for k2, v2 in v.items():
            columns = columns + k2 + ", "
            pattern = '[{}\"\'\]\[]'
            v3 = re.sub(pattern, '', str(v2))
            values = values + str(v3) + "', '"
        print(columns[:-2], end='')    
        print(") VALUES (", end='')
        print(values[:-3], end='')    
        print(")", end ='')
        print("\n")
```
When run, it will put out files with lines like this:
```{bash}
python LabelReader.py > infobox_infobox_record_label.yaml.OUT.sql
python LabelReader.py
```

```{sql}
INSERT INTO labels (label, founded, distributor, parent, founder, genre, country) VALUES ('Big_Chile_Entertainment', '2001', 'Asylum_Records', 'Asylum_Records', 'Chingo_Bling', 'Mexican_Rap', 'United States')

INSERT INTO labels (label, founded, distributor, owners, name, url, genre, location) VALUES ('Below_Par_Records', '2000_in_music', '0: Thorn_EMI, 1: Virgin_Records', 'Jai Al-Attas<br>Mark Catanzariti<br>Matthew Hawkes', 'Below Par Records', 'http://belowpar.org', 'various', 'Darlinghurst,_New_South_Wales')

INSERT INTO labels (label, founded, country, genre, name) VALUES ('Back_Beat_Records', '1957_in_music', 'United_States', 'soul_music', 'Back Beat Records')
```

Notice some things that need attention in this output:

1. Not all records have values for every field. 
2. Some record values have single-quotes inside single-quote delimited values.
3. We don't have any good candiate fields to server as a unique key. 
4. No semi-colon at the end, which sqlite3 probably requires. 

After some editing, these lines can be transformed into usable SQL INSERT statements:
```{bash}
vim infobox_infobox_record_label.yaml.OUT.sql
cat infobox_infobox_record_label.yaml.OUT.sql
```
```{sql}
INSERT INTO labels (label, founded, genre, name, url, country, location) VALUES ('Scat_Records', '1989', 'Indie_rock', 'Scat Records', 'http://www.scatrecords.com', 'United_States', 'Saint_Louis,_Missouri');
INSERT INTO labels (label, founded, distributor, parent, founder, genre, country) VALUES ('American_King_Music', '2006', 'Capitol_Records', 'EMI', 'Shawn_Mims', 'Hip_hop_music', 'United_States_of_America');
INSERT INTO labels (label, founded, genre, name, founder, url, country, location) VALUES ('Arrangers_Publishing_Company', '1985', 'Various', 'Arrangers Publishing Company', 'Jay Dawson', 'http://www.arrpubco.com', 'USA', 'Nashville, TN');
```
...some of the editing went through sed, like this to chop lists:
```{bash}
cat infobox_infobox_record_label.yaml.OUT.sql|sed 's/0: //g'|sed 's/ 1: //g'|sed 's/ 2: //g'|sed 's/ 3: //g'|sed 's/ 4: //g'|sed 's/ 5: //g'|sed 's/ 6: //g'|sed 's/ 7: //g'|sed 's/ 8: //g'|sed 's/ 9: //g'
```

Next we will create another SQL script to use directly with sqlite3:
```{bash}
vim record_labelTableMaker.sql
cat record_labelTableMaker.sql
```

```{sql}
CREATE TABLE labels (A text default null, affiliates text default null, artists text default null, artwork text default null, assistantDirector text default null, associatedActs text default null, contact text default null, country text default null, currentMembers text default null, defunct text default null, director text default null, disbanded text default null, distribution text default null, distributor text default null, distributors text default null, divisions text default null, fenre text default null, folded text default null, found text default null, founded text default null, founder text default null, founder_percent_28s_percent_29 text default null, founders text default null, genre text default null, genres text default null, headquarters text default null, imageBg text default null, imageCaption text default null, img text default null, imgCapt text default null, keyPeople text default null, label text default null, location text default null, mailOrder text default null, motto text default null, name text default null, owner text default null, owners text default null, parent text default null, president text default null, status text default null, typ text default null, type text default null, ulr text default null, url text default null, value text default null, yearsActive text default null);

.read infobox_infobox_record_label.yaml.OUT.sql

CREATE INDEX idxcountry ON labels(country);
CREATE INDEX idxdistributor ON labels(distributor);
CREATE INDEX idxfounded ON labels(founded);
CREATE INDEX idxfounder ON labels(founder);
CREATE INDEX idxgenre ON labels(genre);
CREATE INDEX idximageBg ON labels(imageBg);
CREATE INDEX idxlabel ON labels(label);
CREATE INDEX idxlocation ON labels(location);
CREATE INDEX idxname ON labels(name);
CREATE INDEX idxparent ON labels(parent);
CREATE INDEX idxurl ON labels(url);
```
Notice six things: 

1. That many indexes were created for fields that are often populated. 
2. That an auto-incrementer unique field was NOT used. 
3. All fields get a type of text. 
4. All fields get a default null value. 
5. That .read (an SQLite tool) is used to execute our INSERT statements. 
6. That all of the "possible" fields were obtained. 

Answers/Explanations to these six things:

1. Indexes are expensive to update.  But this database will be inside the 
android application and will never be written-to.  For this reason, 
too many indexes is a good thing and will speed up the queries on the 
columns with an index.  Notice that "CREATE INDEX" statements come AFTER 
the table has been filled (by .read command) with data to index. 
2. We don't need an auto-incrementer or any uniqueness for this app. 
3. Sqlite data type "text" is simple.  Some fields, like 'founded' could 
benefit from having a type of "integer" but this is wiki-authored data and 
some values have non-integer values like "1997-1998".  Text is easy here. 
4. With "default null", every field has a value, possibly null. 
5. .read is an sqlite command...type the ".help" command to learn.  This 
allows us to put the "database populator" SQL (the INSERT statements) into 
a separate file.  This keeps our keeps our record_labelTableMaker.sql file 
clean and easy-to-read and shows plainly our schema.  Seriously, type the 
"sqlite3" command and then type ".help" and read--its great! 
6. Having every field from the source file makes things easier.  It would 
be better to have the "ulr" and "url" field become one field, named "url". 
However, editing the source file to "fix" the data might take alot of time 
and won't be any fun.  It will be easier to overdo the schema with every field. 

All of the possible fields were learned about like this:
```{bash}
cat infobox_infobox_record_label.yaml.OUT.sql|sed 's/.*labels (//'|sed 's/..VALUES.*//'|sort |uniq|sort| tr " " "\n" | sort | uniq -c
      1 A,
      1 affiliates,
      1 artists,
      1 artwork,
      1 assistantDirector,
      1 associatedActs,
      1 contact,
     17 country
    184 country,
      1 currentMembers,
     15 defunct,
      1 director,
      1 disbanded
      2 distribution
     17 distributor
     83 distributor,
      1 distributors,
      1 divisions
      1 fenre,
      1 folded
      1 found
    183 founded,
     35 founder
    109 founder,
      1 founder_percent_28s_percent_29,
      3 founders
      4 founders,
     46 genre
    152 genre,
      3 genres,
      1 headquarters,
     18 imageBg
     34 imageBg,
      1 imageCaption,
      1 img,
      1 imgCapt
      1 keyPeople,
    229 label,
     57 location
     57 location,
      2 mailOrder,
      1 motto
     10 name
    133 name,
      1 owner
      1 owners,
     12 parent
     77 parent,
      1 president,
     22 status,
      1 typ
      2 type
      2 ulr,
      2 url
    147 url,
      1 value,
      2 yearsActive,
```
That output has two benefits we used already:

1. We used it for our record_labelTableMaker.sql schema. 
2. We learn which fields are commonly populated.  These are 
very likely the fields that we will want to search on.  And the 
fields we want to search on are the fields that deserve an 
index, which again, we put into our record_labelTableMaker.sql 
schema. 

Now its time to create our database:
```{bash}
cat infobox_infobox_record_label.yaml.OUT.sql |wc
905
sqlite3 labels < record_labelTableMaker.sql
echo "select count(*) from labels;" | sqlite3 labels
461
mv labels labels_only461records
vim infobox_infobox_record_label.yaml.OUT.sql
sqlite3 labels < record_labelTableMaker.sql
echo "select count(*) from labels;" | sqlite3 labels
905
file labels
labels: SQLite 3.x database
```
We created the database.  That did not run correctly on 
the first try.  There were some single-quotes in the data values 
that threw off the INSERT statements.  By repeatedly creating 
the database and then checking how many records got created, we 
can learn when things finally got inserted correctly (or, at 
least, that the number of records equals the number of INSERT 
statements). 

Here we look at all of our indexed columns, to see which 
ones have not-too-many UNIQUE record values.  Putting a 
short (and sorted) list into an android.app.ListActivity 
might be a good way to search on that column.  For 
example, we see that there are 297 distinct values for 
the "distributor" column.  297 might not be too many 
on most phones.  If they are sorted, then scrollers 
might be able to find "Captiol_Records" reasonably 
quickly.  In this way, a user could find which labels 
have a value of "Capitol_Records" in their "distributor" 
column.  Remember, UNIQUE field values are what we are 
interested in.  In a database with a million records, there 
should only be 50 unique values for the "state" field.  

We want to run these SQL, whose output is shown below:
```{sql}
SELECT count(*) FROM labels WHERE distributor is not null;
SELECT count(*) FROM labels WHERE founded is not null;
SELECT count(*) FROM labels WHERE founder is not null;
SELECT count(*) FROM labels WHERE genre is not null;
SELECT count(*) FROM labels WHERE imageBg is not null;
SELECT count(*) FROM labels WHERE label is not null;
SELECT count(*) FROM labels WHERE location is not null;
SELECT count(*) FROM labels WHERE name is not null;
SELECT count(*) FROM labels WHERE parent is not null;
SELECT count(*) FROM labels WHERE url is not null;

SELECT count(DISTINCT distributor) FROM labels WHERE distributor is not null;
SELECT count(DISTINCT founded) FROM labels WHERE founded is not null;
SELECT count(DISTINCT founder) FROM labels WHERE founder is not null;
SELECT count(DISTINCT genre) FROM labels WHERE genre is not null;
SELECT count(DISTINCT imageBg) FROM labels WHERE imageBg is not null;
SELECT count(DISTINCT label) FROM labels WHERE label is not null;
SELECT count(DISTINCT location) FROM labels WHERE location is not null;
SELECT count(DISTINCT name) FROM labels WHERE name is not null;
SELECT count(DISTINCT parent) FROM labels WHERE parent is not null;
SELECT count(DISTINCT url) FROM labels WHERE url is not null;
```

```
sqlite3 labels
SQLite version 3.7.13 2012-06-11 02:05:22
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite> SELECT count(*) FROM labels WHERE distributor is not null;
437
sqlite> SELECT count(*) FROM labels WHERE founded is not null;
836
sqlite> SELECT count(*) FROM labels WHERE founder is not null;
717
sqlite> SELECT count(*) FROM labels WHERE genre is not null;
869
sqlite> SELECT count(*) FROM labels WHERE imageBg is not null;
125
sqlite> SELECT count(*) FROM labels WHERE label is not null;
905
sqlite> SELECT count(*) FROM labels WHERE location is not null;
484
sqlite> SELECT count(*) FROM labels WHERE name is not null;
504
sqlite> SELECT count(*) FROM labels WHERE parent is not null;
303
sqlite> SELECT count(*) FROM labels WHERE url is not null;
738

sqlite> SELECT count(DISTINCT distributor) FROM labels WHERE distributor is not null;
297
sqlite> SELECT count(DISTINCT founded) FROM labels WHERE founded is not null;
140
sqlite> SELECT count(DISTINCT founder) FROM labels WHERE founder is not null;
697
sqlite> SELECT count(DISTINCT genre) FROM labels WHERE genre is not null;
472
sqlite> SELECT count(DISTINCT imageBg) FROM labels WHERE imageBg is not null;
15
sqlite> SELECT count(DISTINCT label) FROM labels WHERE label is not null;
905
sqlite> SELECT count(DISTINCT location) FROM labels WHERE location is not null;
299
sqlite> SELECT count(DISTINCT name) FROM labels WHERE name is not null;
503
sqlite> SELECT count(DISTINCT parent) FROM labels WHERE parent is not null;
143
sqlite> SELECT count(DISTINCT url) FROM labels WHERE url is not null;
719
sqlite>

sqlite> select distributor from labels where distributor is not null LIMIT 1;
Capitol_Records
```
Our database is ready to be put into the "assets" folder for android. 
As mentioned, we are going to populate an android.app.ListActivity 
with a bunch of choices.  We could query the database directly 
to create the list of choices.  Instead, we will pre-query the 
database to get the list and then hard code long lists into the 
source code of the ListActivity.  This is not-so-bad because our 
database is read-only and so our query results won't change.  It 
also has the benefit that we can remove unwanted values from the 
listing.  In our ListActivity, we will make the list like this:
```{java}
List<String> parentList = new ArrayList<String>();
parentList.add("Epic_Records");
parentList.add("Capitol_Records");
```
And then we will fill the list like this:
```{java}
ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
R.layout.parenttextview, parentList);
setListAdapter(dataAdapter);
ListView listView = getListView();
```
And so in order to create the ArrayList<String>, we need to 
query the database to find all of the unique values for the 
fields we're going to provide search on.  For the parent field, 
this query will get us the data for parentList.add() in the 
example above:
```
sqlite> SELECT count(DISTINCT parent) FROM labels WHERE parent is not null order by parent;
143
sqlite> SELECT DISTINCT parent FROM labels WHERE parent is not null order by parent;
```
From the output, we can create the 143 lines of Java code to 
populate the ArrayList<String>.  Likewise for the other 
fields:
```{sql}
SELECT DISTINCT distributor FROM labels WHERE distributor is not null ORDER BY distributor;
SELECT DISTINCT founded FROM labels WHERE founded is not null ORDER BY founded;
SELECT DISTINCT founder FROM labels WHERE founder is not null ORDER BY founder;
SELECT DISTINCT genre FROM labels WHERE genre is not null ORDER BY genre;
SELECT DISTINCT imageBg FROM labels WHERE imageBg is not null ORDER BY imageBg;
SELECT DISTINCT label FROM labels WHERE label is not null ORDER BY label;
SELECT DISTINCT location FROM labels WHERE location is not null ORDER BY location;
SELECT DISTINCT name FROM labels WHERE name is not null ORDER BY name;
SELECT DISTINCT parent FROM labels WHERE parent is not null ORDER BY parent;
SELECT DISTINCT url FROM labels WHERE url is not null ORDER BY url;
```
On second thought, we probably don't need to search by url or 
by imageBg but the others look to have good interest. 
...also we notice that "name" and "label" have similar values. 

We notice in the list of distinct values of the "location" column 
that there are several values with encoded non-ascii characters. 
To save the expense of editing the source data, these were deleted. 

For the android graphics, we'll need to make on 512x512 image.
Do it in gimp, save it as Recordlabels.xcf
Then export it to Recordlabels.png
Then run these imageMagick conver commands to create the ones you need:
```{bash}
convert Recordlabels.png -resize 48x48 Recordlabels48.png 
convert Recordlabels.png -resize 72x72 Recordlabels72.png 
convert Recordlabels.png -resize 96x96 Recordlabels96.png 
convert Recordlabels.png -resize 144x144 Recordlabels144.png 
```
But to use them in Android, they all need to have the same 
exact name, but reside in different directories.  Therefore, 
we will run a rename command, and then in Eclipse, import the 
currently-properly-named file:
```{bash}
 cp Recordlabels48.png recordlabels.png
```
IN ECLIPSE,RIGHT-CLICK_drawable-mdpi_AND CLICK IMPORT 
```{bash}
 cp Recordlabels72.png recordlabels.png 
```
IN ECLIPSE,RIGHT-CLICK_drawable-hdpi_AND CLICK IMPORT 
```{bash}
 cp Recordlabels96.png recordlabels.png 
```
IN ECLIPSE,RIGHT-CLICK_drawable-xhdpi_AND CLICK IMPORT 
```{bash}
 cp Recordlabels144.png recordlabels.png 
```
IN ECLIPSE,RIGHT-CLICK_drawable-xxhdpi_AND CLICK IMPORT 

In that way, we imported into the proper folder the identically 
named file, using the properly-sized version for each import. 
We double check our importing on the command-line, like this:
```{bash}
file workspace/Recordlabels/res/drawable-mdpi/recordlabels.png 
workspace/Recordlabels/res/drawable-mdpi/recordlabels.png: 
PNG image data, 48 x 48, 8-bit grayscale, non-interlaced

file workspace/Recordlabels/res/drawable-hdpi/recordlabels.png 
workspace/Recordlabels/res/drawable-hdpi/recordlabels.png: 
PNG image data, 72 x 72, 8-bit grayscale, non-interlaced

file workspace/Recordlabels/res/drawable-xhdpi/recordlabels.png 
workspace/Recordlabels/res/drawable-xhdpi/recordlabels.png: 
PNG image data, 96 x 96, 8-bit grayscale, non-interlaced

file workspace/Recordlabels/res/drawable-xxhdpi/recordlabels.png 
workspace/Recordlabels/res/drawable-xxhdpi/recordlabels.png: 
PNG image data, 144 x 144, 8-bit grayscale, non-interlaced
```
And to get Android to use our images, we edit AndroidManifest.xml
```{xml}
        android:icon="@drawable/recordlabels"
```
