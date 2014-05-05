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

import android.app.ListActivity;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.util.Log;

public class Founded extends ListActivity {
	static final String TAG = "LABELS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}
	
	private void displayListView() {
		List<String> foundedList = new ArrayList<String>();
	    foundedList.add("1896");
	    foundedList.add("1898");
	    foundedList.add("19??");
	    foundedList.add("1901");
	    foundedList.add("1902");
	    foundedList.add("1910");
	    foundedList.add("1916");
	    foundedList.add("1922");
	    foundedList.add("1924");
	    foundedList.add("1926");
	    foundedList.add("1927");
	    foundedList.add("1929");
	    foundedList.add("1934");
	    foundedList.add("1939");
	    foundedList.add("1942");
	    foundedList.add("1943");
	    foundedList.add("1945");
	    foundedList.add("1947");
	    foundedList.add("1949");
	    foundedList.add("1950");
	    foundedList.add("1951");
	    foundedList.add("1952");
	    foundedList.add("1953");
	    foundedList.add("1954");
	    foundedList.add("1955");
	    foundedList.add("1956");
	    foundedList.add("1957");
	    foundedList.add("1958");
	    foundedList.add("1959");
	    foundedList.add("1960");
	    foundedList.add("1961");
	    foundedList.add("1962");
	    foundedList.add("1964");
	    foundedList.add("1965");
	    foundedList.add("1966");
	    foundedList.add("1967");
	    foundedList.add("1968");
	    foundedList.add("1969");
	    foundedList.add("1970");
	    foundedList.add("1971");
	    foundedList.add("1972");
	    foundedList.add("1973");
	    foundedList.add("1974");
	    foundedList.add("1975");
	    foundedList.add("1976");
	    foundedList.add("1977");
	    foundedList.add("1978");
	    foundedList.add("1979");
	    foundedList.add("1980");
	    foundedList.add("1980s");
	    foundedList.add("1981");
	    foundedList.add("1982");
	    foundedList.add("1983");
	    foundedList.add("1984");
	    foundedList.add("1985");
	    foundedList.add("1986");
	    foundedList.add("1987");
	    foundedList.add("1988");
	    foundedList.add("1989");
	    foundedList.add("1990");
	    foundedList.add("1990s");
	    foundedList.add("1991");
	    foundedList.add("1992");
	    foundedList.add("1993");
	    foundedList.add("1994");
	    foundedList.add("1995");
	    foundedList.add("1996");
	    foundedList.add("1997");
	    foundedList.add("1998");
	    foundedList.add("1999");
	    foundedList.add("2000");
	    foundedList.add("2000s");
	    foundedList.add("2001");
	    foundedList.add("2002");
	    foundedList.add("2003");
	    foundedList.add("2004");
	    foundedList.add("2005");
	    foundedList.add("2006");
	    foundedList.add("2007");
	    foundedList.add("April");
	    foundedList.add("Cedar");
	    foundedList.add("Early 90s");
	    foundedList.add("Late 1970s");
	    foundedList.add("November 11");
	    foundedList.add("September 20");
	    foundedList.add("unknown");
	    foundedList.add("Unknown");
	    // create an ArrayAdaptar from the String Array
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, foundedList);
	    setListAdapter(dataAdapter);
	    ListView listView = getListView();
	    // enables filtering for the contents of the given ListView
	    listView.setTextFilterEnabled(true);
	    listView.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Intent i = new Intent("");
			    String foundedChoice = ((TextView) view).getText().toString();
			    i.setData(Uri.parse(foundedChoice));
			    setResult(RESULT_OK, i);
		    	finish();
		    }
    	});
    }	    

}
