/**Copyright (C) 2013 Thomas Maher
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.recordlabels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DBAdapter {
	static final String TAG = "DBAdapter";
	static final String DATABASE_NAME = "labels";
	static final String DATABASE_TABLE = "labels";
	static final int DATABASE_VERSION = 1;
        static final String A = "A";
        static final String affiliates = "affiliates";
        static final String artists = "artists";
        static final String artwork = "artwork";
        static final String assistantDirector = "assistantDirector";
        static final String associatedActs = "associatedActs";
        static final String contact = "contact";
        static final String country = "country";
        static final String currentMembers = "currentMembers";
        static final String defunct = "defunct";
        static final String director = "director";
        static final String disbanded = "disbanded";
        static final String distribution = "distribution";
        static final String distributor = "distributor";
        static final String distributors = "distributors";
        static final String divisions = "divisions";
        static final String fenre = "fenre";
        static final String folded = "folded";
        static final String found = "found";
        static final String founded = "founded";
        static final String founder = "founder";
        static final String founder_percent_28s_percent_29 = "founder_percent_28s_percent_29";
        static final String founders = "founders";
        static final String genre = "genre";
        static final String genres = "genres";
        static final String headquarters = "headquarters";
        static final String imageBg = "imageBg";
        static final String imageCaption = "imageCaption";
        static final String img = "img";
        static final String imgCapt = "imgCapt";
        static final String keyPeople = "keyPeople";
        static final String label = "label";
        static final String location = "location";
        static final String mailOrder = "mailOrder";
        static final String motto = "motto";
        static final String name = "name";
        static final String owner = "owner";
        static final String owners = "owners";
        static final String parent = "parent";
        static final String president = "president";
        static final String status = "status";
        static final String typ = "typ";
        static final String type = "type";
        static final String ulr = "ulr";
        static final String url = "url";
        static final String value = "value";
        static final String yearsActive = "yearsActive";

	static final String DATABASE_CREATE = "CREATE TABLE labels (A text default null, affiliates text default null, artists text default null, artwork text default null, assistantDirector text default null, associatedActs text default null, contact text default null, country text default null, currentMembers text default null, defunct text default null, director text default null, disbanded text default null, distribution text default null, distributor text default null, distributors text default null, divisions text default null, fenre text default null, folded text default null, found text default null, founded text default null, founder text default null, founder_percent_28s_percent_29 text default null, founders text default null, genre text default null, genres text default null, headquarters text default null, imageBg text default null, imageCaption text default null, img text default null, imgCapt text default null, keyPeople text default null, label text default null, location text default null, mailOrder text default null, motto text default null, name text default null, owner text default null, owners text default null, parent text default null, president text default null, status text default null, typ text default null, type text default null, ulr text default null, url text default null, value text default null, yearsActive text default null);";

	final Context context;

	DatabaseHelper DBHelper;
	SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
	}

	// ---opens the database---
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper.close();
	}

	public Cursor getByLocation(String locationParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "location LIKE ?";		
		locationParam = locationParam + "%";
		Log.w(TAG, "In DBAdapter.getByLocation(), searching location for: " + locationParam);
		String[] selectionArgs = new String[] { locationParam };
		Log.w(TAG, "In DBAdapter.getByLocation(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByLocation(String location), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByLocation(String location), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByLocation(String location), about to return cursor, c");
		return mCursor;
	}	
	
	public Cursor getByFounder(String founderParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "founder LIKE ?";
		founderParam = founderParam + "%";
		Log.w(TAG, "In DBAdapter.getByFounder(), searching founder for: " + founderParam);
		String[] selectionArgs = new String[] { founderParam };
		Log.w(TAG, "In DBAdapter.getByFounder(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByFounder(String founder), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByFounder(String founder), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByFounder(String founder), about to return cursor, c");
		return mCursor;
	}
	
	public Cursor getByParent(String parentParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "parent LIKE ?";
		parentParam = parentParam + "%";
		Log.w(TAG, "In DBAdapter.getByParent(), searching parent for: " + parentParam);
		String[] selectionArgs = new String[] { parentParam };
		Log.w(TAG, "In DBAdapter.getByParent(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByParent(String parent), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByParent(String parent), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByParent(String parent), about to return cursor, c");
		return mCursor;
	}
	public Cursor getByDistributor(String distributorParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "distributor LIKE ?";
		distributorParam = distributorParam + "%";
		Log.w(TAG, "In DBAdapter.getByDistributor(), searching distributor for: " + distributorParam);
		String[] selectionArgs = new String[] { distributorParam };
		Log.w(TAG, "In DBAdapter.getByDistributor(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByDistributor(String distributor), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByDistributor(String distributor), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByDistributor(String distributor), about to return cursor, c");
		return mCursor;
	}		
	public Cursor getByGenre(String genreParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "genre LIKE ?";
		genreParam = genreParam + "%";
		Log.w(TAG, "In DBAdapter.getByGenre(), searching genre for: " + genreParam);
		String[] selectionArgs = new String[] { genreParam };
		Log.w(TAG, "In DBAdapter.getByGenre(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByGenre(String genre), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByGenre(String genre), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByGenre(String genre), about to return cursor, c");
		return mCursor;
	}	
	public Cursor getByFounded(String foundedParam) throws SQLException {
		String[] columns = new String[] { A,affiliates,artists,artwork,assistantDirector,associatedActs,contact,country,currentMembers,defunct,director,disbanded,distribution,distributor,distributors,divisions,fenre,folded,found,founded,founder,founder_percent_28s_percent_29,founders,genre,genres,headquarters,imageBg,imageCaption,img,imgCapt,keyPeople,label,location,mailOrder,motto,name,owner,owners,parent,president,status,typ,type,ulr,url,value,yearsActive};				
		String selection;		
		selection = "founded LIKE ?";
		foundedParam = foundedParam + "%";
		Log.w(TAG, "In DBAdapter.getByFounded(), searching founded for: " + foundedParam);
		String[] selectionArgs = new String[] { foundedParam };
		Log.w(TAG, "In DBAdapter.getByFounded(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Log.w(TAG, "In DBAdapter.getByFounded(String founded), About to check if Cursor c is null");
		if (mCursor != null) {
			Log.w(TAG,"In DBAdapter.getByFounded(String founded), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		Log.w(TAG, "In DBAdapter.getByFounded(String founded), about to return cursor, c");
		return mCursor;
	}	
}
