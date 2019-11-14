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

                if (i ==0){
                    Fragment playersFragment = new PlayersFragment();
                    transaction.replace(R.id.fragment_container, playersFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (i == 1){
                    Fragment settingsFragment = new SettingsFragment();
                    transaction.replace(R.id.fragment_container, settingsFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if (i == 2){
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else if (i == 3){

                }
                else if (i == 4){

                }
                else if (i == 5){

                }
                else if (i == 6){

                }
                else if (i == 7){

                }
                else if (i == 8){

                }
                else if (i == 9){

                }
                else if (i == 10){

                }
                else if (i == 11){

                }
                else if (i == 12){

                }
                else if (i == 13){

                }
                else if (i == 14){

                }
                else if (i == 15){

                }
                else if (i == 16){

                }
                else if (i == 17){

                }
                else if (i == 18){

                }
                else if (i == 19){

                }
                else if (i == 20){

                }
                else if (i == 21){

                }
                else if (i == 22){

                }
                else if (i == 23){

                }
                else if (i == 24){

                }
                else if (i == 25){

                }
                else if (i == 26){

                }
                else if (i == 27){

                }
                else if (i == 28){

                }
                else if (i == 29){

                }
            }
        });

        return view;








    }
}
