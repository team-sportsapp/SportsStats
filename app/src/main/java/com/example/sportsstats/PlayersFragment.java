package com.example.sportsstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Comparator;


public class PlayersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, null);

        final String[] players = getResources().getStringArray(R.array.players);

        ListView listView = (ListView) view.findViewById(R.id.playerListView);

        //array adapter

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                players);

        //adapter setter
        listView.setAdapter(listViewAdapter);

        /*
        listViewAdapter.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                                //FragmentTransaction transaction = fragmentManager.beginTransaction();

                                                Fragment playersPopupFragment = new PlayersPopupFragment();
                                                Bundle args = new Bundle();
                                                args.putString("Key", players[i]);

                                                playersPopupFragment.setArguments(args);
                                                getFragmentManager()
                                                        .beginTransaction()
                                                        .replace(R.id.fragment_container, playersPopupFragment)
                                                        .addToBackStack(null)
                                                        .commit();

                                            }
                                        });
        return view;

    }
}
