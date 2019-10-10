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
//https://www.youtube.com/watch?v=edZwD54xfbk
import java.util.Collections;
import java.util.Comparator;


public class PlayersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, null);

        //players array
        String playersArray[] = new String[] {"a", "b", "c", "yii", "oscar", "llm", "jjja", "hm", "ii", "gk", "fc", "ed", "lo", "ki", "ko",
                "la", "zz", "ae", "pe", "pa", "op", "p",
                    "t", "s", "k", "b", "y", "z"};


        ListView listView = (ListView) view.findViewById(R.id.playerList);

        //array adapter
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                playersArray);

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
