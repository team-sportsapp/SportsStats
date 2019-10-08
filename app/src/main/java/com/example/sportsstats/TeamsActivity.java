package com.example.sportsstats;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeamsActivity extends AppCompatActivity {

    ListView teamsListView;
    String[] teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        Resources res = getResources();
        //teamsListView = (ListView) findViewById(R.id.teamsListView);
      //  teams = res.getStringArray(R.array.teams);

    //    teamsListView.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_teams, teams));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_teams, teams);
    }
}
