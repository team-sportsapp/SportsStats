package com.example.sportsstats;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MatchesActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

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
