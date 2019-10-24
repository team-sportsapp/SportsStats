package com.example.sportsstats;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
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
import java.util.List;

public class MatchesActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

//changed arraylist from list
 List<MatchesSample> matchesSamples = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // load home when app is just opened after login
        loadFragment(new HomeFragment());

        //load matches list
        readMatchesData();

        //array adapter    (matchesSamples.size(i))


/*
        for(int i = 0; i < matchesSamples.size() ; i++){
            System.out.println(matchesSamples.get(i).getDate());
        }*/

System.out.println("TEST PRINT B4");






        lv = (ListView) findViewById(R.id.matchesList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MatchesActivity.this, android.R.layout.simple_list_item_1);

        lv.setAdapter(arrayAdapter);








       // setText.findViewById(R.id.simple_list_item_1).('hah');
    }

    //matches
    private void readMatchesData(){
        InputStream is = getResources().openRawResource(R.raw.october2019);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

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

                Log.d("MyActivity", "Just Created: " + sample);

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

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
