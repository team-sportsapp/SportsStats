package com.example.sportsstats;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchesActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

//TextView textv = (TextView) findViewById(R.id.fragmentid2);


    //ListView listView = (ListView) findViewById(R.id.matchesList);
    int t = 0;
    //TextView textElement;


    //changed matches sample to String


    //List<MatchesSample> matchesSamples = new ArrayList<>();
    //InputStream inputStream;
    //String matchesArray[];
    //int t =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        //textviews
        //TextView newtext = (TextView) findViewById(R.id.matchesList);
        TextView setTextView = (TextView) findViewById(R.id.matchesList);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // load home when app is just opened after login
        loadFragment(new HomeFragment());

        //load matches list
        readMatchesData();

        String concat = "\n";
        for (int i = 0; i < 60; i++) {
            concat += "\t" + matchesSamples.get(i).getDate() +
                    "  " + matchesSamples.get(i).getTime()
                    + "  " + matchesSamples.get(i).getHome() + "  " + matchesSamples.get(i).getAway() + "\n";
        }
      //  MainActivity.fillUp = new String(concat);
        Log.d("MyActivity", "Line: " + concat);

        System.out.println(matchesSamples.get(1).getDate());
        System.out.println(matchesSamples.get(4).getDate());


        //String stringArray[] = Arrays.asList(matchesSamples).toArray(new String[t]);

        //System.out.println(Arrays.toString(stringArray));
        //testArray = matchesSamples.toArray().toString();

        /*
        //array adapter
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                matchesSamples);

        //adapter setter
        listView.setAdapter(listViewAdapter);


*/


        //  Log.d("MyActivity", "Testing get text" + textv.getText());


        //array adapter    (matchesSamples.size(i))


/*
        for(int i = 0; i < matchesSamples.size() ; i++){
            System.out.println(matchesSamples.get(i).getDate());
        }*/

        System.out.println("TEST PRINT B4");

/*

        lv = (ListView) findViewById(R.id.matchesList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MatchesActivity.this, android.R.layout.simple_list_item_1);

        lv.setAdapter(arrayAdapter);*/



    }


    List<MatchesSample> matchesSamples = new ArrayList<>();

    //matches
    private void readMatchesData(){
        InputStream inputStream = getResources().openRawResource(R.raw.october2019);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


        String line = "";
        try{
            //step over header
            reader.readLine();
            while ((line = reader.readLine()) != null){
                Log.d("MyActivity", "Line: " + line);
                //split by commas
                String[] tokens = line.split(",");

                //read data
                MatchesSample sample = new MatchesSample();
                sample.setDate(tokens[0]);
                sample.setTime(tokens[1]);
                sample.setAway(tokens[2]);
                sample.setHome(tokens[3]);

                matchesSamples.add(sample);
                t++;

                Log.d("MyActivity", "Just Created: " + sample);

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
        //testArray = new String [t];
        Log.d("MyActivity", "FULL ARRAY LIST");
        Log.d("MyActivity", "asdf" + matchesSamples);
        Log.d("MyActivity", "END ARRAY LIST");

    }

    //load fragment
    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch(menuItem.getItemId()){
            case R.id.action_matches:
                fragment = new HomeFragment();
                break;

            case R.id.action_fantasy:
                fragment = new FantasyFragment();
                break;

            case R.id.action_teams:
                fragment = new TeamsFragment();
                break;

            case R.id.action_players:
                fragment = new PlayersFragment();
                break;

            case R.id.action_settings:
                fragment = new SettingsFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
