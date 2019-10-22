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
        View viewTwo = inflater.inflate(R.layout.fragment_teams, null);

        //players array
        //String teamArray[] = new String[] {"team 1", "team 2"};

       String[] team = getResources().getStringArray(R.array.teams);

        ListView listViewTwo = (ListView) viewTwo.findViewById(R.id.teamsListView);

        //array adapter
        ArrayAdapter<String> listViewAdapterTwo = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                team);

        //adapter setter
        listViewTwo.setAdapter(listViewAdapterTwo);

        listViewAdapterTwo.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        return viewTwo;








    }
}
