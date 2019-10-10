package com.example.sportsstats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.Subject;

public class TeamsFragment extends ListFragment {
    // use .png for image files
    // listview with images and text in fragment
    //https://www.tutorialspoint.com/how-to-display-a-list-of-images-and-text-in-a-listview-in-android
    /*
    String[] teams;
    int[] images= {R.drawable.facebook, R.drawable.instagram};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;
    */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    /*
        //MAP
        HashMap<String, String> map = new HashMap<String, String>();

        //FILL THE MAP
        for(int i=0;i<teams.length;i++){
            map = new HashMap<String, String>();
            map.put("Team", teams[i]);
            map.put("Images", Integer.toString(images[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from = {"Team", "Images"};

        //IDS OF VIEWS
        int[] to={R.id.teamNameTextView, R.id.teamLogoImageView};

        //ADAPTER
        adapter = new SimpleAdapter(getActivity(), data, R.layout.fragment_teams, from, to);
        setListAdapter(adapter);
    */
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    /*
    @Override
    public void onStart(){
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Toast.makeText(getActivity(), data.get(pos).get("Team"), Toast.LENGTH_SHORT).show();
            }
        });
    }
    */



}
