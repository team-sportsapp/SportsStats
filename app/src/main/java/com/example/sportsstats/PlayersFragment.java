package com.example.sportsstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Comparator;

//https://www.youtube.com/watch?v=edZwD54xfbk

public class PlayersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, null);

        String[] players = getResources().getStringArray(R.array.players);

        ListView listView = (ListView) view.findViewById(R.id.playerListView);

        //array adapter

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                players);

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
                    Fragment teamsFragment = new TeamsFragment();
                    transaction.replace(R.id.fragment_container, teamsFragment);
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
