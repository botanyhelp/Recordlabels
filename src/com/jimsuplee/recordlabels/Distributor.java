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

public class Distributor extends ListActivity {
	static final String TAG = "LABELS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}
	private void displayListView() {
		List<String> distributorList = new ArrayList<String>();
	    distributorList.add("ABKCO Records");
	    distributorList.add("ADA");
	    distributorList.add("ADA (Alternative Distribution Alliance)");
	    distributorList.add("Afterschool_Sound_Records");
	    distributorList.add("Allegro");
	    distributorList.add("Alternative_Distribution_Alliance");
	    distributorList.add("A&M Records ");
	    distributorList.add("Arbors_Records");
	    distributorList.add("Arista_Nashville");
	    distributorList.add("Asylum_Records");
	    distributorList.add("Atlantic");
	    distributorList.add("Atlantic Records ");
	    distributorList.add("Atlantic_Records");
	    distributorList.add("Atlantic Records Group ");
	    distributorList.add("Atlantic_Records_Group");
	    distributorList.add("Avex_Trax");
	    distributorList.add("Bad_Boy_Records");
	    distributorList.add("Barsuk");
	    distributorList.add("Beggars_Group");
	    distributorList.add("Blue Collar Distro");
	    distributorList.add("Blue_Note_Label_Group");
	    distributorList.add("BME_Recordings");
	    distributorList.add("BMG (since 1999)");
	    distributorList.add("BNA_Records");
	    distributorList.add("Bomp!_Records");
	    distributorList.add("Bonnier Music Publishing");
	    distributorList.add("Buddah Records (1970-1973)");
	    distributorList.add("Burgundy Records");
	    distributorList.add("Calif_Music_Group");
	    distributorList.add("Capitol Music Group");
	    distributorList.add("Capitol_Music_Group");
	    distributorList.add("Capitol_Records");
	    distributorList.add("Cargo Distribution (UK)");
	    distributorList.add("Cargo_Records");
	    distributorList.add("Caroline_Distribution");
	    distributorList.add("Caroline_Records_(U.S.)");
	    distributorList.add("Chamillitary_Entertainment");
	    distributorList.add("Clone");
	    distributorList.add("Columbia Records ");
	    distributorList.add("Columbia_Records");
	    distributorList.add("Concord_Music_Group");
	    distributorList.add("Credential_Recordings");
	    distributorList.add("Crimson_Productions");
	    distributorList.add("Crosstalk International");
	    distributorList.add("Decca Records");
	    distributorList.add("Decca_Records");
	    distributorList.add("Def_Jam_Recordings");
	    distributorList.add("Delos International");
	    distributorList.add("Deutsche_Austrophon");
	    distributorList.add("Deutsche_Grammophon");
	    distributorList.add("Deutsche Grammophon Records");
	    distributorList.add("Diamante_Distribution");
	    distributorList.add("Diamante_Music_Group");
	    distributorList.add("Diplomat_Records");
	    distributorList.add("Drakkar_Productions");
	    distributorList.add("Dutch_East_India_Trading");
	    distributorList.add("East West Records");
	    distributorList.add("East_West_Records");
	    distributorList.add("Ebullition");
	    distributorList.add("Edition Drakkar");
	    distributorList.add("Elektra Records ");
	    distributorList.add("EMI");
	    distributorList.add("EMI_Music_Group");
	    distributorList.add("EMI Records");
	    distributorList.add("Enja_Records");
	    distributorList.add("Epic Records");
	    distributorList.add("Epic_Records");
	    distributorList.add("Escovator Records");
	    distributorList.add("Ferret_Music");
	    distributorList.add("Festival_Mushroom_Records");
	    distributorList.add("Festival_Records");
	    distributorList.add("Fontana_Dist");
	    distributorList.add("Fontana_Distribution");
	    distributorList.add("Fontana North Distribution");
	    distributorList.add("Fontana Records ");
	    distributorList.add("Fontana_Records");
	    distributorList.add("Forced_Exposure");
	    distributorList.add("Frogville Records");
	    distributorList.add("Frontline_Records");
	    distributorList.add("Full_Surface_Records");
	    distributorList.add("Fusion_III");
	    distributorList.add("Gallo Record Company ");
	    distributorList.add("Geffen_Records");
	    distributorList.add("Gema");
	    distributorList.add("GNP Crescendo Records");
	    distributorList.add("Gusto Records");
	    distributorList.add("Gutta_Music");
	    distributorList.add("Heart Beat Distribution");
	    distributorList.add("Helium 3");
	    distributorList.add("IDN");
	    distributorList.add("Independent");
	    distributorList.add("Independent_label");
	    distributorList.add("Independent_record_label");
	    distributorList.add("Indigo_(record_company)");
	    distributorList.add("Inertia_Distribution");
	    distributorList.add("Infinity Music Distribution");
	    distributorList.add("INO");
	    distributorList.add("Interscope");
	    distributorList.add("Interscope-Geffen-A&M");
	    distributorList.add("Interscope_Records");
	    distributorList.add("IODA");
	    distributorList.add("Iris");
	    distributorList.add("IRIS (South Africa)");
	    distributorList.add("IROND Records (Russia)");
	    distributorList.add("Kennis Music");
	    distributorList.add("Kingsway_Communications");
	    distributorList.add("Koch_Distribution");
	    distributorList.add("Koch Entertainment");
	    distributorList.add("Koch_Entertainment");
	    distributorList.add("Koch_Entertainment_Distribution");
	    distributorList.add("Koch Records");
	    distributorList.add("Koch_Records");
	    distributorList.add("Lico_Records");
	    distributorList.add("Little_Red_Button_Records");
	    distributorList.add("London Records");
	    distributorList.add("London_Records");
	    distributorList.add("Lookout! Records");
	    distributorList.add("Lumberjack Mordam Music Group");
	    distributorList.add("Lumberjack_Mordam_Music_Group");
	    distributorList.add("Machete_Music");
	    distributorList.add("Major");
	    distributorList.add("Mercury Records ");
	    distributorList.add("MGM_Distribution");
	    distributorList.add("Ministerios_Salem_Internacional");
	    distributorList.add("Mordam_Records");
	    distributorList.add("Mr._Collipark");
	    distributorList.add("Mute_Records");
	    distributorList.add("Nail");
	    distributorList.add("Nail_Distribution");
	    distributorList.add("Navarre Corporation (US)");
	    distributorList.add("Nordic Mission");
	    distributorList.add("Nova_Media_Distribution");
	    distributorList.add("Outside_Music");
	    distributorList.add("Ozit Records");
	    distributorList.add("Parlophone");
	    distributorList.add("Parlophone Records ");
	    distributorList.add("Plastichead");
	    distributorList.add("Plastic_Head");
	    distributorList.add("Play_It_Again_Sam");
	    distributorList.add("Poison_City_Records");
	    distributorList.add("Polydor_Records");
	    distributorList.add("Priority Records ");
	    distributorList.add("Proper Music Distribution ");
	    distributorList.add("Prosto Records");
	    distributorList.add("Provident_Label_Group");
	    distributorList.add("PRT");
	    distributorList.add("R");
	    distributorList.add("Ranwood Records");
	    distributorList.add("RCA_Records");
	    distributorList.add("RCA Records Group");
	    distributorList.add("RCA_Records_Group");
	    distributorList.add("RCA Victor Group");
	    distributorList.add("Red Destribution");
	    distributorList.add("RED_Distribution");
	    distributorList.add("Redeye");
	    distributorList.add("RedEye");
	    distributorList.add("Redeye Distribution");
	    distributorList.add("RedEye_Distribution");
	    distributorList.add("Reverberation");
	    distributorList.add("Reverberation_(record_label)");
	    distributorList.add("Revolver_Distribution");
	    distributorList.add("Rhino_Entertainment");
	    distributorList.add("Robber Baron Music");
	    distributorList.add("Ryko");
	    distributorList.add("Rykodisc");
	    distributorList.add("Sanctuary_Records");
	    distributorList.add("SC Distribution");
	    distributorList.add("seeking one");
	    distributorList.add("Self-distributed");
	    distributorList.add("Self-Distributed ");
	    distributorList.add("Shellshock");
	    distributorList.add("Shellshock ");
	    distributorList.add("Shellshock (UK)");
	    distributorList.add("Shock_Records");
	    distributorList.add("Simple Machines");
	    distributorList.add("Sonic_Unyon");
	    distributorList.add("Sony");
	    distributorList.add("Sony_BMG");
	    distributorList.add("Sony_BMG_Masterworks");
	    distributorList.add("Sony_BMG_Music_Entertainment");
	    distributorList.add("Sony_Music_Entertainment");
	    distributorList.add("Sony Music (label is now defunct)");
	    distributorList.add("Sony_Records");
	    distributorList.add("Sony (US)");
	    distributorList.add("Southern Records");
	    distributorList.add("Southern_Records");
	    distributorList.add("Sphere Marketing & Distribution Inc.");
	    distributorList.add("SRC_Records");
	    distributorList.add("SST Records");
	    distributorList.add("SST_Records");
	    distributorList.add("Star_Records");
	    distributorList.add("Stomp (Australia)");
	    distributorList.add("STOMP_Distribution");
	    distributorList.add("Strange_Fruit_Records");
	    distributorList.add("Studio Distribution");
	    distributorList.add("Sumthing_Distribution");
	    distributorList.add("Taraneh_Enterprises");
	    distributorList.add("The Island Def Jam Music Group ");
	    distributorList.add("The_Island_Def_Jam_Music_Group");
	    distributorList.add("The_Orchard_(music_label)");
	    distributorList.add("The_Universal_Motown");
	    distributorList.add("The_Universal_Motown_");
	    distributorList.add("Thorn_EMI");
	    distributorList.add("Tommy Boy Music");
	    distributorList.add("Touch_and_Go_Records");
	    distributorList.add("Tuba_Records");
	    distributorList.add("Tunecore ");
	    distributorList.add("TVT Distribution");
	    distributorList.add("Twilight_Distribution");
	    distributorList.add("United_States");
	    distributorList.add("Universal (Canada)");
	    distributorList.add("Universal_Motown_Records_Group");
	    distributorList.add("Universal music");
	    distributorList.add("Universal_Music");
	    distributorList.add("Universal_Music_Canada");
	    distributorList.add("Universal Music Enterprises");
	    distributorList.add("Universal_Music_Group");
	    distributorList.add("Universal_Music_Group_International");
	    distributorList.add("Universal_Music_Latino");
	    distributorList.add("Universal_Music_&_Video_Distribution");
	    distributorList.add("Universal Records");
	    distributorList.add("Universal_Records");
	    distributorList.add("Vanguard Records");
	    distributorList.add("Various");
	    distributorList.add("Venus");
	    distributorList.add("Verve_Records");
	    distributorList.add("VI_Music");
	    distributorList.add("Virgin Records");
	    distributorList.add("Virgin_Records");
	    distributorList.add("Visual_Arts");
	    distributorList.add("Vital");
	    distributorList.add("Warner Bros. Records ");
	    distributorList.add("Warner_Bros._Records");
	    distributorList.add("Warner_Music");
	    distributorList.add("Warner_Music_Canada");
	    distributorList.add("Warner_Music_Group");
	    distributorList.add("WEA_International");
	    distributorList.add("Witchdoctor Distribution Code7");
	    distributorList.add("Word_Records");
	    distributorList.add("World Serpent Distribution (1988-2004)");
	    distributorList.add("Worlds_Fair");
	    distributorList.add("Zetima_Records");
	    distributorList.add("Zomba_Label_Group");
	    distributorList.add("Zomba_Music_Group");
	    
	    // create an ArrayAdaptar from the String Array
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, distributorList);
	    setListAdapter(dataAdapter);
	    ListView listView = getListView();
	    // enables filtering for the contents of the given ListView
	    listView.setTextFilterEnabled(true);
	    listView.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Intent i = new Intent("");
			    String distributorChoice = ((TextView) view).getText().toString();
			    i.setData(Uri.parse(distributorChoice));
			    setResult(RESULT_OK, i);
		    	finish();
		    }
    	});
	}
}
