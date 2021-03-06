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

public class Location extends ListActivity {
	static final String TAG = "LABELS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}
	
	private void displayListView() {
		List<String> locationList = new ArrayList<String>();
        locationList.add("Ann_Arbor");
        locationList.add("Arizona");
        locationList.add("Arlington");
        locationList.add("Athens");
        locationList.add("Atlanta");
        locationList.add("Auckland");
        locationList.add("Aurora");
        locationList.add("Austin");
        locationList.add("Austria");
        locationList.add("Bahrain");
        locationList.add("Batesville");
        locationList.add("Bath");
        locationList.add("Bay_Area");
        locationList.add("Berlin");
        locationList.add("Birmingham");
        locationList.add("Bloomington");
        locationList.add("Brentwood");
        locationList.add("Brighton");
        locationList.add("Brisbane");
        locationList.add("Bristol");
        locationList.add("British_Columbia");
        locationList.add("Brooklyn");
        locationList.add("Brussels");
        locationList.add("Budapest");
        locationList.add("Calgary");
        locationList.add("California");
        locationList.add("California Bay Area");
        locationList.add("Camperdown");
        locationList.add("Canada");
        locationList.add("Cardiff");
        locationList.add("Chapel_Hill");
        locationList.add("Charlotte");
        locationList.add("Charlottesville");
        locationList.add("Chicago");
        locationList.add("Chorlton");
        locationList.add("Cologne");
        locationList.add("Copenhagen");
        locationList.add("County_Meath");
        locationList.add("Coxsackie");
        locationList.add("Dallas");
        locationList.add("Darlinghurst");
        locationList.add("Detroit");
        locationList.add("Donnellson");
        locationList.add("Easthampton");
        locationList.add("East_Ivanhoe");
        locationList.add("Edinburgh");
        locationList.add("Edmonton");
        locationList.add("Eilat");
        locationList.add("El_Paso");
        locationList.add("Encinitas");
        locationList.add("Encino");
        locationList.add("England");
        locationList.add("Essex");
        locationList.add("Eugene");
        locationList.add("Evansville");
        locationList.add("Finland");
        locationList.add("Fitzroy");
        locationList.add("Florida");
        locationList.add("Fortitude_Valley");
        locationList.add("France");
        locationList.add("Frankfurt");
        locationList.add("Franklin");
        locationList.add("Fremantle");
        locationList.add("Germany");
        locationList.add("Glasgow");
        locationList.add("Hamburg");
        locationList.add("Hampshire");
        locationList.add("Hauho");
        locationList.add("Helsinki");
        locationList.add("Hesse");
        locationList.add("Hoboken");
        locationList.add("Hollywood");
        locationList.add("Hong_Kong");
        locationList.add("Houston");
        locationList.add("Hyperspace");
        locationList.add("Illinois");
        locationList.add("India");
        locationList.add("Istanbul");
        locationList.add("Kingston upon Thames");
        locationList.add("Kingsville");
        locationList.add("Krung_Thep");
        locationList.add("Lane_Cove_West");
        locationList.add("Lawndale");
        locationList.add("Leeds");
        locationList.add("Lehigh_Valley");
        locationList.add("Lexington");
        locationList.add("Lisbon");
        locationList.add("Liverpool");
        locationList.add("Lodi");
        locationList.add("London");
        locationList.add("Los Angeles");
        locationList.add("Los_Angeles");
        locationList.add("Lyndhurst");
        locationList.add("Mainz");
        locationList.add("Manchester");
        locationList.add("Maryland");
        locationList.add("Mascot");
        locationList.add("Massachusetts");
        locationList.add("Melbourne");
        locationList.add("Memphis");
        locationList.add("Metro_Detroit");
        locationList.add("Miami");
        locationList.add("Milwaukee");
        locationList.add("Minneapolis");
        locationList.add("Minnesota");
        locationList.add("Mobile");
        locationList.add("Montreal");
        locationList.add("Moscow");
        locationList.add("Munich");
        locationList.add("Nashville");
        locationList.add("New_Brunswick");
        locationList.add("New_Jersey");
        locationList.add("New_Orleans");
        locationList.add("New_York");
        locationList.add("New_York_City");
        locationList.add("Northamptonshire");
        locationList.add("North_Carolina");
        locationList.add("Northcote");
        locationList.add("Northeim");
        locationList.add("North_Melbourne");
        locationList.add("North_Perth");
        locationList.add("Norway");
        locationList.add("Nottingham");
        locationList.add("Oakland");
        locationList.add("Oak_Park");
        locationList.add("OConnor");
        locationList.add("Ohio");
        locationList.add("Olympia");
        locationList.add("Omaha");
        locationList.add("Ontario");
        locationList.add("Oregon");
        locationList.add("Orinda");
        locationList.add("Orlando");
        locationList.add("Oxfordshire");
        locationList.add("Paris");
        locationList.add("Pennsylvania");
        locationList.add("Pensacola");
        locationList.add("Perth");
        locationList.add("Philadelphia");
        locationList.add("Phoenix");
        locationList.add("Port_Arthur");
        locationList.add("Portland");
        locationList.add("Prague");
        locationList.add("Queens");
        locationList.add("Queensland");
        locationList.add("Raleigh");
        locationList.add("Reykjav");
        locationList.add("Richmond");
        locationList.add("Rochester");
        locationList.add("Room 1208");
        locationList.add("Rotterdam");
        locationList.add("Royal_Oak");
        locationList.add("Saint_Louis");
        locationList.add("San_Diego");
        locationList.add("San_Francisco");
        locationList.add("San_Rafael");
        locationList.add("Santa_Fe");
        locationList.add("Santa_Monica");
        locationList.add("Saskatoon");
        locationList.add("Scotland");
        locationList.add("Seattle");
        locationList.add("Sheffield");
        locationList.add("Sherman_Oaks");
        locationList.add("Sherwood_Park");
        locationList.add("Somerville");
        locationList.add("South_Carolina");
        locationList.add("Southern_England");
        locationList.add("Staffordshire");
        locationList.add("St_Alban");
        locationList.add("Stavanger");
        locationList.add("St. Louis");
        locationList.add("St._Louis");
        locationList.add("Stockholm");
        locationList.add("Strawberry_Hills");
        locationList.add("Sugar_Land");
        locationList.add("Surrey");
        locationList.add("Surry_Hills");
        locationList.add("Sweden");
        locationList.add("Sydney");
        locationList.add("Tamil_Nadu");
        locationList.add("Taylor");
        locationList.add("Tennessee");
        locationList.add("Texas");
        locationList.add("Tokyo");
        locationList.add("Toronto");
        locationList.add("United_Kingdom");
        locationList.add("United_States");
        locationList.add("USA");
        locationList.add("Utah");
        locationList.add("Vancouver");
        locationList.add("Various");
        locationList.add("Vermont");
        locationList.add("Victoria_(Australia)");
        locationList.add("Vienna");
        locationList.add("Virginia");
        locationList.add("Warsaw");
        locationList.add("Washington");
        locationList.add("West_Java");
        locationList.add("Westminster");
        locationList.add("West_Sussex");
        locationList.add("Whiteabbey");
        locationList.add("Windsor");
        locationList.add("Winnipeg");
        locationList.add("Yarmouth");
        locationList.add("Yorkshire");
		// create an ArrayAdaptar from the String Array
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, locationList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		// enables filtering for the contents of the given ListView
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String locationChoice = ((TextView) view).getText().toString();
				i.setData(Uri.parse(locationChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});

	}
}
