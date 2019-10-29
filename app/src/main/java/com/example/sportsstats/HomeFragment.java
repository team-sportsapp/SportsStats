package com.example.sportsstats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //load matches list
        readMatchesData();

        return inflater.inflate(R.layout.fragment_home, null);
    }

    List<MatchesSample> matchesSamples = new ArrayList<>();

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

        return;
    }
}

