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

public class Parentlabel extends ListActivity {
	static final String TAG = "LABELS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}
	
	private void displayListView() {
		List<String> parentList = new ArrayList<String>();
	    parentList.add("A Different Drum");
	    parentList.add("ABKCO_Records");
	    parentList.add("ABS Entertainment Inc.");
	    parentList.add("ABS-CBN");
	    parentList.add("Anodyne Records");
	    parentList.add("Apple_Corps");
	    parentList.add("Aquarius_Records_(record_label)");
	    parentList.add("Ardent_Music_LLC");
	    parentList.add("Asbestos Records");
	    parentList.add("Ashford Productions");
	    parentList.add("Asylum_Records");
	    parentList.add("Atlantic");
	    parentList.add("Atlantic_Records");
	    parentList.add("BMG");
	    parentList.add("BMG UK & Ireland");
	    parentList.add("Beggars_Group");
	    parentList.add("Black_Hole_Recordings");
	    parentList.add("Bridge_End_Productions");
	    parentList.add("Brunswick Records");
	    parentList.add("Buena_Vista_Music_Group");
	    parentList.add("CBS_Corporation");
	    parentList.add("Caltex Records");
	    parentList.add("Candid Records");
	    parentList.add("Capitol_Records");
	    parentList.add("Cash_Money_Records");
	    parentList.add("Cold_Chillin_Records");
	    parentList.add("Columbia Music Entertainment, Inc.");
	    parentList.add("Columbia_Records,Sony_BMG");
	    parentList.add("Concord_Music_Group");
	    parentList.add("Cowboy_Junkies");
	    parentList.add("DBS Group Entertainment - Turkey");
	    parentList.add("DRT_Entertainment");
	    parentList.add("Decca_Records");
	    parentList.add("Diplomat_Records");
	    parentList.add("Dutch_East_India_Trading");
	    parentList.add("EMI");
	    parentList.add("EMI,Mute_Records");
	    parentList.add("EMI_CMG");
	    parentList.add("East Asia Record");
	    parentList.add("El_Saturn_Records");
	    parentList.add("Epic_Records");
	    parentList.add("Epitaph_Records");
	    parentList.add("Frontline_Records_(1980s)");
	    parentList.add("Frontline_Records_(1980s),Newpax_Records");
	    parentList.add("Fueled_by_Ramen");
	    parentList.add("GNP Crescendo Records");
	    parentList.add("Genge_Entertainment");
	    parentList.add("Gusto_Records");
	    parentList.add("Guttar Music Entertainment");
	    parentList.add("HEADWAX ORGANIZATION");
	    parentList.add("Harper Collins");
	    parentList.add("Headbangers Entertainment");
	    parentList.add("Hood_Musik_Entertainment");
	    parentList.add("IEC Record, IEC (HKEX Stock Code 8118)");
	    parentList.add("Independent");
	    parentList.add("Independent_record_label");
	    parentList.add("Interscope");
	    parentList.add("Interscope_Records");
	    parentList.add("Key_(company)");
	    parentList.add("Kill_Rock_Stars");
	    parentList.add("Koch_Distribution");
	    parentList.add("Koch_Entertainment");
	    parentList.add("Koch_Entertainment_Canada");
	    parentList.add("Koch_Entertainment_LP");
	    parentList.add("Les_Disques_du_Crepuscule");
	    parentList.add("Little_Red_Button_Records");
	    parentList.add("Lumberjack_Mordam_Music_Group");
	    parentList.add("MGM_Distribution");
	    parentList.add("Maloof_Productions");
	    parentList.add("Maple Core Ltd.");
	    parentList.add("MapleCore Ltd.");
	    parentList.add("Maranatha!_Music");
	    parentList.add("Mr_R&B_Record_Sales");
	    parentList.add("MySpace");
	    parentList.add("N/A");
	    parentList.add("Navarre_Canada");
	    parentList.add("Navarre_Corporation");
	    parentList.add("Nettwerk");
	    parentList.add("None");
	    parentList.add("OneRace_Films");
	    parentList.add("Parlophone");
	    parentList.add("Polydor_Records");
	    parentList.add("Pro-Active_Recordings_Ltd");
	    parentList.add("RED_Distribution,Sony_BMG");
	    parentList.add("Recommended_Records");
	    parentList.add("Right_Quick_Music");
	    parentList.add("Roc-A-Fella_Records");
	    parentList.add("Ropeadope_Records");
	    parentList.add("Rough_Trade_Records");
	    parentList.add("Rounder_Records");
	    parentList.add("Ruff_Ryders_Entertainment");
	    parentList.add("Rykodisc");
	    parentList.add("SPZ_Group");
	    parentList.add("SST_Records");
	    parentList.add("Sanctuary_Records");
	    parentList.add("Shadowville Inc.");
	    parentList.add("Sleeping_Bag_Records");
	    parentList.add("Sony");
	    parentList.add("Sony-BMG");
	    parentList.add("Sony_BMG");
	    parentList.add("Sony_BMG_Music_Entertainment");
	    parentList.add("Sony_Music");
	    parentList.add("Sony_Music_Japan");
	    parentList.add("Spinner");
	    parentList.add("Spring_Hill_Music_Group");
	    parentList.add("Spun_Records");
	    parentList.add("Starbucks");
	    parentList.add("Sub_Pop");
	    parentList.add("Sun Entertainment Corp.");
	    parentList.add("Supermercados_Peruanos");
	    parentList.add("TBD");
	    parentList.add("TC Music, LLC");
	    parentList.add("The Bonnier Group");
	    parentList.add("The_Walt_Disney_Company");
	    parentList.add("Tooth_&_Nail");
	    parentList.add("Tooth_and_Nail_Records");
	    parentList.add("Touch_and_Go_Records");
	    parentList.add("Universal_Music");
	    parentList.add("Universal_Music_Canada");
	    parentList.add("Universal_Music_Group");
	    parentList.add("Universal_Music_Group_International");
	    parentList.add("Universal_Records");
	    parentList.add("Up-Front Works Co. Ltd.");
	    parentList.add("V2_Records");
	    parentList.add("Vermiform");
	    parentList.add("Virgin_Records");
	    parentList.add("Virgin_Records,EMI");
	    parentList.add("Voiceprint");
	    parentList.add("Warner_Bros._Records");
	    parentList.add("Warner_Bros._Records,News_Limited");
	    parentList.add("Warner_Music");
	    parentList.add("Warner_Music_Canada");
	    parentList.add("Warner_Music_Group");
	    parentList.add("Warner_Music_Group,Avusa");
	    parentList.add("Warner_Music_Group,Bad_Boy_South");
	    parentList.add("Warner_Music_Group,East_West_Records");
	    parentList.add("Welk_Music_Group");
	    parentList.add("Word_Records");
	    parentList.add("ZZO_Recordings");
	    parentList.add("Zomba_Music_Group");
	    parentList.add("gray dot, inc");
	    parentList.add("lowercase_people");
	    // create an ArrayAdaptar from the String Array
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, parentList);
	    setListAdapter(dataAdapter);
	    ListView listView = getListView();
	    // enables filtering for the contents of the given ListView
	    listView.setTextFilterEnabled(true);
	    listView.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Intent i = new Intent("");
			    String parentChoice = ((TextView) view).getText().toString();
			    i.setData(Uri.parse(parentChoice));
			    setResult(RESULT_OK, i);
		    	finish();
		    }
    	});
	}
}
