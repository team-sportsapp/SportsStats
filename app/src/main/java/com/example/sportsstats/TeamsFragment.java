package com.example.sportsstats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Comparator;


public class TeamsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, null);

        //players array
        //String teamArray[] = new String[] {"team 1", "team 2"};

       String[] team = getResources().getStringArray(R.array.teams);

        ListView listView = (ListView) view.findViewById(R.id.teamsListView);

        //array adapter
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                team);

        //adapter setter
        listView.setAdapter(listViewAdapter);

        listViewAdapter.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        return view;








    }
}
