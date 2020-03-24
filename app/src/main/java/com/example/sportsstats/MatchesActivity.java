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

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // load home when app is just opened after login
        loadFragment(new HomeFragment());
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
