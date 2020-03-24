package com.example.sportsstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.widget.SimpleAdapter;
import android.widget.Toast;


public class TeamsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, null);

        String[] teams = getResources().getStringArray(R.array.teams);

        /*
    int[] logos = new int[]{
            R.drawable.ah,
            R.drawable.bc,
            R.drawable.bn,
            R.drawable.cb,
            R.drawable.cc,
            R.drawable.ch,
            R.drawable.dm,
            R.drawable.dn,
            R.drawable.dp,
            R.drawable.gsw,
            R.drawable.hr,
            R.drawable.ip,
            R.drawable.lac,
            R.drawable.lal,
            R.drawable.meg,
            R.drawable.miah,
            R.drawable.mib,
            R.drawable.mt,
            R.drawable.nop,
            R.drawable.nyk,
            R.drawable.oct,
            R.drawable.om,
            R.drawable.ps,
            R.drawable.psuns,
            R.drawable.ptb,
            R.drawable.sack,
            R.drawable.sanas,
            R.drawable.tr,
            R.drawable.uj,
            R.drawable.ww
    };
    */
        //players array
        //String teamArray[] = new String[] {"team 1", "team 2"};
    /*
        ListView listView = (ListView) view.findViewById(R.id.teamsListView);
        TeamsAdapter teamsAdapter = new TeamsAdapter(getActivity(), teams, logos);
        listView.setAdapter(teamsAdapter);
    */
    /*

       List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();

       for(int i=0; i<team.length; i++){
           HashMap<String,String> hm = new HashMap<String, String>();
           hm.put("teamLogo", Integer.toString(logos[i]));
           hm.put("teamName", (String) team[i]);
           aList.add(hm);
       }

       String[] from = {"teamLogo", "teamName"};
       int[] to = {R.id.teamLogo, R.id.teamName};

       SimpleAdapter adapter = new SimpleAdapter(view.getContext(), aList, R.layout.fragment_teams, from, to);
       ListView listView = (ListView) view.findViewById(R.id.teamsListView);

        */

        ListView listView = (ListView) view.findViewById(R.id.teamsListView);

        //array adapter
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                teams);

        //adapter setter


        listView.setAdapter(listViewAdapter);

        listViewAdapter.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if (i ==0){ //Atlanta Hawks
                    Fragment playersFragment = new PlayersFragment();
                    transaction.replace(R.id.fragment_container, playersFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (i == 1){ //Boston Celtics
                    Fragment settingsFragment = new SettingsFragment();
                    transaction.replace(R.id.fragment_container, settingsFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (i == 2){ //Brooklyn Nets
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else if (i == 3){ //Charlotte Hornets

                }
                else if (i == 4){ //Chicago Bulls

                }
                else if (i == 5){ //Cleveland Cavaliers

                }
                else if (i == 6){ //Dallas Mavericks

                }
                else if (i == 7){ //Denver Nuggets

                }
                else if (i == 8){ //Detroit Pistons

                }
                else if (i == 9){ //Golden State Warriors

                }
                else if (i == 10){ //Houston Rockets

                }
                else if (i == 11){ //Indiana Pacers

                }
                else if (i == 12){ //LA Clippers

                }
                else if (i == 13){ //LA Lakers

                }
                else if (i == 14){ //Memphis Grizzlies

                }
                else if (i == 15){ //Miami Heat

                }
                else if (i == 16){ //Milwaukee Bucks

                }
                else if (i == 17){ //Minnesota Timberwolves

                }
                else if (i == 18){ //New Orleans Pelicans

                }
                else if (i == 19){ //New York Knicks

                }
                else if (i == 20){ //Oklahoma City Thunder

                }
                else if (i == 21){ //Orlando Magic

                }
                else if (i == 22){ //Philadelphia Sixers

                }
                else if (i == 23){ //Phoenix Suns

                }
                else if (i == 24){ //Portland Tail Blazers

                }
                else if (i == 25){ //Sacramento Kings

                }
                else if (i == 26){ //San Antonio Spurs

                }
                else if (i == 27){ //Toronto Raptors

                }
                else if (i == 28){ //Utah Jazz

                }
                else if (i == 29){ //Washington Wizards

                }
            }
        });

        return view;

    }
}
