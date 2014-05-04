package com.jimsuplee.recordlabels;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Recordlabels extends Activity {
	DBAdapter db;
	static final String TAG = "LABELS";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlabels);
		try {
			String destPath = "/data/data/" + getPackageName() + "/databases";
			File f = new File(destPath);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();
				Toast.makeText(this, "Please Wait...Database Being Created",
						Toast.LENGTH_LONG).show();
				CopyDB(getBaseContext().getAssets().open("labels"),
						new FileOutputStream(destPath + "/labels"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Now that we (hopefully) have an SQLiteDatabase available, lets make
		// an adapter and put it
		// into our global variable.
		db = new DBAdapter(this);
	}
	
	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// copy 1K bytes of file at a time
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

	public void onClickLocation(View view) {
		Log.w(TAG, "In Recordlabels.onClickLocation()");
		Intent iLocation = new Intent("com.jimsuplee.recordlabels.Location");
		startActivityForResult(iLocation, 0);
	}
	public void onClickFounder(View view) {
		Log.w(TAG, "In Recordlabels.onClickFounder()");
		Intent iFounder = new Intent("com.jimsuplee.recordlabels.Founder");
		startActivityForResult(iFounder, 1);
	}
	public void onClickParentlabel(View view) {
		Log.w(TAG, "In Recordlabels.onClickParentlabel()");
		Intent iParent = new Intent("com.jimsuplee.recordlabels.Parentlabel");
		startActivityForResult(iParent, 2);
	}
	public void onClickDistributor(View view) {
		Log.w(TAG, "In Recordlabels.onClickDistributor()");
		Intent iDistributor = new Intent("com.jimsuplee.recordlabels.Distributor");
		startActivityForResult(iDistributor, 4);
	}		
	public void onClickGenre(View view) {
		Log.w(TAG, "In Recordlabels.onClickGenre()");
		Intent iGenre = new Intent("com.jimsuplee.recordlabels.Genre");
		startActivityForResult(iGenre, 5);
	}	
	public void onClickFounded(View view) {
		Log.w(TAG, "In Recordlabels.onClickFounded()");
		Intent iFounded = new Intent("com.jimsuplee.recordlabels.Founded");
		startActivityForResult(iFounded, 6);
	}	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ---check if the request code is 0 1 2 3 4 5---
		Log.w(TAG, "In Recordlabels.onActivityResult(), checking reqCod");
		// onClickLocation startActivityForResult section
		if (requestCode == 0) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String location = data.getData().toString();
				Cursor c = db.getByLocation(location);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}		
		if (requestCode == 1) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=1,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String founder = data.getData().toString();
				Cursor c = db.getByFounder(founder);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}
		if (requestCode == 2) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=2,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String parent = data.getData().toString();
				Cursor c = db.getByParent(parent);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}
		if (requestCode == 3) {
			Log.w(TAG,
					"In Recordlabels.onActivityResult(int-reqCode=3,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				String recordLabelData = Html.fromHtml(data.getData().toString()).toString();
				TextView tv = (TextView) findViewById(R.id.txt_Recordlabeldata);
				tv.setVisibility(View.VISIBLE);
				tv.setText(recordLabelData);
			}
		}
		if (requestCode == 4) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=4,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String distributor = data.getData().toString();
				Cursor c = db.getByDistributor(distributor);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}
		if (requestCode == 5) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=5,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String genre = data.getData().toString();
				Cursor c = db.getByGenre(genre);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}		
		if (requestCode == 6) {
			Log.w(TAG, "In Recordlabels.onActivityResult(int-reqCode=6,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String founded = data.getData().toString();
				Cursor c = db.getByFounded(founded);
				String results = "";
				if (c != null) {
					
				}
				if (c.moveToFirst()) {
					do {
						//results += "Occurred: " + c.getString(0) + "-" + c.getString(8) + "___";
						//results = "A: " + c.getString(0) + "affiliates: " + c.getString(1) + "artists: " + c.getString(2) + "artwork: " + c.getString(3) + "assistantDirector: " + c.getString(4) + "associatedActs: " + c.getString(5) + "contact: " + c.getString(6) + "country: " + c.getString(7) + "currentMembers: " + c.getString(8) + "defunct: " + c.getString(9) + "director: " + c.getString(10) + "disbanded: " + c.getString(11) + "distribution: " + c.getString(12) + "distributor: " + c.getString(13) + "distributors: " + c.getString(14) + "divisions: " + c.getString(15) + "fenre: " + c.getString(16) + "folded: " + c.getString(17) + "found: " + c.getString(18) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "founder_percent_28s_percent_29: " + c.getString(21) + "founders: " + c.getString(22) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "imageBg: " + c.getString(26) + "imageCaption: " + c.getString(27) + "img: " + c.getString(28) + "imgCapt: " + c.getString(29) + "keyPeople: " + c.getString(30) + "label: " + c.getString(31) + "location: " + c.getString(32) + "mailOrder: " + c.getString(33) + "motto: " + c.getString(34) + "name: " + c.getString(35) + "owner: " + c.getString(36) + "owners: " + c.getString(37) + "parent: " + c.getString(38) + "president: " + c.getString(39) + "status: " + c.getString(40) + "typ: " + c.getString(41) + "type: " + c.getString(42) + "ulr: " + c.getString(43) + "url: " + c.getString(44) + "value: " + c.getString(45) + "yearsActive: " + c.getString(46);
						//results = 	"country: " + c.getString(7) + "distributor: " + c.getString(13) + "founded: " + c.getString(19) + "founder: " + c.getString(20) + "genre: " + c.getString(23) + "genres: " + c.getString(24) + "headquarters: " + c.getString(25) + "label: " + c.getString(31) + "location: " + c.getString(32) + "name: " + c.getString(35) + "parent: " + c.getString(38) + "url: " + c.getString(44)  + "___";
						//results = 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						results += 	"name: " + c.getString(35) + "\nurl: " + c.getString(44) + "\ndistributor: " + c.getString(13) + "\nfounded: " + c.getString(19) + "\nfounder: " + c.getString(20) + "\nparent: " + c.getString(38) + "\ngenre: " + c.getString(23) + "\nlabel: " + c.getString(31) + "\nlocation: " + c.getString(32) + "\ncountry: " + c.getString(7) + "___";
						} while (c.moveToNext());
				} else {
					
				}
				Intent iResults = new Intent("com.jimsuplee.recordlabels.Results");
				iResults.putExtra("results", results);
				startActivityForResult(iResults, 3);
				db.close();
			}
		}	
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recordlabels, menu);
        return true;
    }
    
}
