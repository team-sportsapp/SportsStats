package com.example.sportsstats;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalLayoutManager;
import devs.mulham.horizontalcalendar.model.CalendarEvent;
import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container, false);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();



        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });



        //load matches list
        readMatchesData();

        //List view
        ListView listView =(ListView) view.findViewById(R.id.matchesList);

        //arrayadapter
        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                matchesSamples
        );

        //tell list view to use adapter for screen
        listView.setAdapter(listViewAdapter);


        //return inflater.inflate(R.layout.fragment_home, null);
        return view;
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

                if(tokens[0].contains("Oct")) {
                    sample.setDate(tokens[0]);
                    sample.setTime(tokens[1]);
                    sample.setAway(tokens[2]);
                    sample.setHome(tokens[3]);
                    matchesSamples.add(sample);
                }


                Log.d("MyActivity", "Just Created: " + sample);

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}

