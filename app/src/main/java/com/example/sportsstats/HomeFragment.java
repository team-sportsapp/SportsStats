package com.example.sportsstats;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalLayoutManager;
import devs.mulham.horizontalcalendar.model.CalendarEvent;
import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

import static android.icu.util.Calendar.DATE;

public class HomeFragment extends Fragment {
    //int month;
    TextView textView;
    ListView listView;
    Calendar instanceDate;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home,container, false);

        //sample text view
        textView = (TextView) view.findViewById(R.id.textView);
        //List view
        listView =(ListView) view.findViewById(R.id.matchesList);


        /* starts before 5 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -5);

        /* ends after 6 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 6);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

      //read data here
        readMatchesData();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(final java.util.Calendar date, int position) {


                //do something
                //Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!", Toast.LENGTH_SHORT).show();
                //String str = s

                Calendar currDate = date;
                Date test2 = currDate.getTime();
                int currMonth = currDate.getTime().getMonth();
                //add 1 to currMonth so its not 0 through 11
                currMonth += 1;
                //Log.d("MyActivity", "CURRENT MONTH ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS: " + month);
                Log.d("MyActivity", "CURRENT MONTH FROM GET TIME IS........:" + test2);
                Log.d("MyActivity", "CURRENT MONTH FROM GET MONTH IS........:" + currMonth);
                //Date test = date.getTime();
               // Date monthTest = date.getMonth();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

                String userDate = dateFormat.format(currDate.getTime());


                Log.d("MyActivity", "CLICKED DATE " + userDate);
                int x = Integer.parseInt(userDate);

                //october
                if(currMonth == 10){

                }

                //november
                if(currMonth == 11){

                }

                //december
                if(currMonth == 12) {
                    if (x == 8) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                decemberEightSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 9) {


                        //Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");

                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                decemberNineSamples
                        );

                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);

                        // Log.d("MyActivity", "x = 10 " + matchesSamples);
                        // inflater.inflate(R.layout.the_child_view, parent);


                        // listView.addView(   )

                    }


                    if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");

                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                decemberTenSamples
                        );

                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);

                        //Log.d("MyActivity", "x = 10 " + matchesSamples);


                    }


                    if (x == 11) {


                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");

                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                decemberElevenSamples
                        );

                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);

                        //Log.d("MyActivity", "x = 10 " + matchesSamples);
                        // inflater.inflate(R.layout.the_child_view, parent);


                        // listView.addView(   )

                    }
                    if (x == 15) {


                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");

                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                decemberFifteenthSamples
                        );

                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);

                        //Log.d("MyActivity", "x = 10 " + matchesSamples);
                        // inflater.inflate(R.layout.the_child_view, parent);


                        // listView.addView(   )

                    }
                }

                //january
                if(currMonth == 1){

                }

                //february
                if(currMonth == 2){
                    if (x == 1) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febOneSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 2) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febTwoSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 3) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febThreeSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 4) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febFourSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 5) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febFiveSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 6) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febSixSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 7) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febSevenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 8) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febEightSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 9) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febNineSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febTenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 11) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febElevenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 12) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febTwelveSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 13) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febThirteenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 20) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                febTwentySamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 21) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb21Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 22) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb22Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 23) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb23Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 24) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb24Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 25) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb25Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 26) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb26Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 27) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb27Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 28) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                feb28Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }

                }

                //march
                if(currMonth == 3){
                    if (x == 1) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchOneSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 2) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchTwoSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 3) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchThreeSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 4) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchFourSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 5) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchFiveSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 6) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchSixSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 7) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchSevenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 8) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchEightSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 9) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchNineSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate);
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchTenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 11) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                marchElevenSamples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                }

            }//end onDateSelected
        });//end CalendarListener
        //return inflater.inflate(R.layout.fragment_home, null);
        Log.d("MyActivity", "VIEW ID:" + view);
        return view;
    }//end OnCreateView

    //Samples made here as arrays
    //List<MatchesSample> matchesSamples = new ArrayList<>();
        //october
        //november
        //december
        List<MatchesSample> decemberEightSamples = new ArrayList<>();
        List<MatchesSample> decemberNineSamples = new ArrayList<>();
        List<MatchesSample> decemberTenSamples = new ArrayList<>();
        List<MatchesSample> decemberElevenSamples = new ArrayList<>();
        List<MatchesSample> decemberFifteenthSamples = new ArrayList<>();
        //january

        //february
        List<MatchesSample> febOneSamples = new ArrayList<>();
        List<MatchesSample> febTwoSamples = new ArrayList<>();
        List<MatchesSample> febThreeSamples = new ArrayList<>();
        List<MatchesSample> febFourSamples = new ArrayList<>();
        List<MatchesSample> febFiveSamples = new ArrayList<>();
        List<MatchesSample> febSixSamples = new ArrayList<>();
        List<MatchesSample> febSevenSamples = new ArrayList<>();
        List<MatchesSample> febEightSamples = new ArrayList<>();
        List<MatchesSample> febNineSamples = new ArrayList<>();
        List<MatchesSample> febTenSamples = new ArrayList<>();
        List<MatchesSample> febElevenSamples = new ArrayList<>();
        List<MatchesSample> febTwelveSamples = new ArrayList<>();
        List<MatchesSample> febThirteenSamples = new ArrayList<>();
        List<MatchesSample> febTwentySamples = new ArrayList<>();
        List<MatchesSample> feb21Samples = new ArrayList<>();
        List<MatchesSample> feb22Samples = new ArrayList<>();
        List<MatchesSample> feb23Samples = new ArrayList<>();
        List<MatchesSample> feb24Samples = new ArrayList<>();
        List<MatchesSample> feb25Samples = new ArrayList<>();
        List<MatchesSample> feb26Samples = new ArrayList<>();
        List<MatchesSample> feb27Samples = new ArrayList<>();
        List<MatchesSample> feb28Samples = new ArrayList<>();



        //march
        List<MatchesSample> marchOneSamples = new ArrayList<>();
        List<MatchesSample> marchTwoSamples = new ArrayList<>();
        List<MatchesSample> marchThreeSamples = new ArrayList<>();
        List<MatchesSample> marchFourSamples = new ArrayList<>();
        List<MatchesSample> marchFiveSamples = new ArrayList<>();
        List<MatchesSample> marchSixSamples = new ArrayList<>();
        List<MatchesSample> marchSevenSamples = new ArrayList<>();
        List<MatchesSample> marchEightSamples = new ArrayList<>();
        List<MatchesSample> marchNineSamples = new ArrayList<>();
        List<MatchesSample> marchTenSamples = new ArrayList<>();
        List<MatchesSample> marchElevenSamples = new ArrayList<>();


        //read matches data method
    public void readMatchesData(){
        InputStream inputStream = getResources().openRawResource(R.raw.season19_20new);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


        //HashMap<String, Integer> eventDate = new HashMap<String, Integer>();

        String line = "";
        try{
            //step over header
            reader.readLine();
            while ((line = reader.readLine()) != null){
                Log.d("MyActivity", "Line: " + line);
                //split by commas
                String[] tokens = line.split(",");

                //******** READ DATA BY MONTHS/DATES*********
                //december
                MatchesSample decemberEight = new MatchesSample();
                if (tokens[0].contains("Dec 8 2019")) {
                    decemberEight.setDate(tokens[0]);
                    decemberEight.setTime(tokens[1]);
                    decemberEight.setAway(tokens[2]);
                    decemberEight.setHome(tokens[3]);
                    decemberEight.setHomeWin(tokens[4]);
                    decemberEight.setAwayWin(tokens[5]);
                    decemberEightSamples.add(decemberEight);
                }
                MatchesSample decemberNine = new MatchesSample();
                if (tokens[0].contains("Dec 9 2019")) {
                    decemberNine.setDate(tokens[0]);
                    decemberNine.setTime(tokens[1]);
                    decemberNine.setAway(tokens[2]);
                    decemberNine.setHome(tokens[3]);
                    decemberNine.setHomeWin(tokens[4]);
                    decemberNine.setAwayWin(tokens[5]);
                    decemberNineSamples.add(decemberNine);
                }
                MatchesSample decemberTen = new MatchesSample();
                if (tokens[0].contains("Dec 10 2019")) {
                    decemberTen.setDate(tokens[0]);
                    decemberTen.setTime(tokens[1]);
                    decemberTen.setAway(tokens[2]);
                    decemberTen.setHome(tokens[3]);
                    decemberTen.setHomeWin(tokens[4]);
                    decemberTen.setAwayWin(tokens[5]);
                    decemberTenSamples.add(decemberTen);
                }
                MatchesSample decemberEleven = new MatchesSample();
                if (tokens[0].contains("Dec 11 2019")) {
                    decemberEleven.setDate(tokens[0]);
                    decemberEleven.setTime(tokens[1]);
                    decemberEleven.setAway(tokens[2]);
                    decemberEleven.setHome(tokens[3]);
                    decemberEleven.setHomeWin(tokens[4]);
                    decemberEleven.setAwayWin(tokens[5]);
                    decemberElevenSamples.add(decemberEleven);
                }
                MatchesSample decemberFifteen = new MatchesSample();
                if (tokens[0].contains("Dec 15 2019")) {
                    decemberFifteen.setDate(tokens[0]);
                    decemberFifteen.setTime(tokens[1]);
                    decemberFifteen.setAway(tokens[2]);
                    decemberFifteen.setHome(tokens[3]);
                    decemberFifteen.setHomeWin(tokens[4]);
                    decemberFifteen.setAwayWin(tokens[5]);
                    decemberFifteenthSamples.add(decemberFifteen);
                }
                //***********FEBRUARY************
                MatchesSample feb1 = new MatchesSample();
                if (tokens[0].contains("Feb 1 2020")) {
                    feb1.setDate(tokens[0]);
                    feb1.setTime(tokens[1]);
                    feb1.setAway(tokens[2]);
                    feb1.setHome(tokens[3]);
                    feb1.setHomeWin(tokens[4]);
                    feb1.setAwayWin(tokens[5]);
                    febOneSamples.add(feb1);
                }
                MatchesSample feb2 = new MatchesSample();
                if (tokens[0].contains("Feb 2 2020")) {
                    feb2.setDate(tokens[0]);
                    feb2.setTime(tokens[1]);
                    feb2.setAway(tokens[2]);
                    feb2.setHome(tokens[3]);
                    feb2.setHomeWin(tokens[4]);
                    feb2.setAwayWin(tokens[5]);
                    febTwoSamples.add(feb2);
                }
                MatchesSample feb3 = new MatchesSample();
                if (tokens[0].contains("Feb 3 2020")) {
                    feb3.setDate(tokens[0]);
                    feb3.setTime(tokens[1]);
                    feb3.setAway(tokens[2]);
                    feb3.setHome(tokens[3]);
                    feb3.setHomeWin(tokens[4]);
                    feb3.setAwayWin(tokens[5]);
                    febThreeSamples.add(feb3);
                }
                MatchesSample feb4 = new MatchesSample();
                if (tokens[0].contains("Feb 4 2020")) {
                    feb4.setDate(tokens[0]);
                    feb4.setTime(tokens[1]);
                    feb4.setAway(tokens[2]);
                    feb4.setHome(tokens[3]);
                    feb4.setHomeWin(tokens[4]);
                    feb4.setAwayWin(tokens[5]);
                    febFourSamples.add(feb4);
                }
                MatchesSample feb5 = new MatchesSample();
                if (tokens[0].contains("Feb 5 2020")) {
                    feb5.setDate(tokens[0]);
                    feb5.setTime(tokens[1]);
                    feb5.setAway(tokens[2]);
                    feb5.setHome(tokens[3]);
                    feb5.setHomeWin(tokens[4]);
                    feb5.setAwayWin(tokens[5]);
                    febFiveSamples.add(feb5);
                }
                MatchesSample feb6 = new MatchesSample();
                if (tokens[0].contains("Feb 6 2020")) {
                    feb6.setDate(tokens[0]);
                    feb6.setTime(tokens[1]);
                    feb6.setAway(tokens[2]);
                    feb6.setHome(tokens[3]);
                    feb6.setHomeWin(tokens[4]);
                    feb6.setAwayWin(tokens[5]);
                    febSixSamples.add(feb6);
                }
                MatchesSample feb7 = new MatchesSample();
                if (tokens[0].contains("Feb 7 2020")) {
                    feb7.setDate(tokens[0]);
                    feb7.setTime(tokens[1]);
                    feb7.setAway(tokens[2]);
                    feb7.setHome(tokens[3]);
                    feb7.setHomeWin(tokens[4]);
                    feb7.setAwayWin(tokens[5]);
                    febSevenSamples.add(feb7);
                }
                MatchesSample feb8 = new MatchesSample();
                if (tokens[0].contains("Feb 8 2020")) {
                    feb8.setDate(tokens[0]);
                    feb8.setTime(tokens[1]);
                    feb8.setAway(tokens[2]);
                    feb8.setHome(tokens[3]);
                    feb8.setHomeWin(tokens[4]);
                    feb8.setAwayWin(tokens[5]);
                    febEightSamples.add(feb8);
                }
                MatchesSample feb9 = new MatchesSample();
                if (tokens[0].contains("Feb 9 2020")) {
                    feb9.setDate(tokens[0]);
                    feb9.setTime(tokens[1]);
                    feb9.setAway(tokens[2]);
                    feb9.setHome(tokens[3]);
                    feb9.setHomeWin(tokens[4]);
                    feb9.setAwayWin(tokens[5]);
                    febNineSamples.add(feb9);
                }
                MatchesSample feb10 = new MatchesSample();
                if (tokens[0].contains("Feb 10 2020")) {
                    feb10.setDate(tokens[0]);
                    feb10.setTime(tokens[1]);
                    feb10.setAway(tokens[2]);
                    feb10.setHome(tokens[3]);
                    feb10.setHomeWin(tokens[4]);
                    feb10.setAwayWin(tokens[5]);
                    febTenSamples.add(feb10);
                }
                MatchesSample feb11 = new MatchesSample();
                if (tokens[0].contains("Feb 11 2020")) {
                    feb11.setDate(tokens[0]);
                    feb11.setTime(tokens[1]);
                    feb11.setAway(tokens[2]);
                    feb11.setHome(tokens[3]);
                    feb11.setHomeWin(tokens[4]);
                    feb11.setAwayWin(tokens[5]);
                    febElevenSamples.add(feb11);
                }
                MatchesSample feb12 = new MatchesSample();
                if (tokens[0].contains("Feb 12 2020")) {
                    feb12.setDate(tokens[0]);
                    feb12.setTime(tokens[1]);
                    feb12.setAway(tokens[2]);
                    feb12.setHome(tokens[3]);
                    feb12.setHomeWin(tokens[4]);
                    feb12.setAwayWin(tokens[5]);
                    febTwelveSamples.add(feb12);
                }
                MatchesSample feb13 = new MatchesSample();
                if (tokens[0].contains("Feb 13 2020")) {
                    feb13.setDate(tokens[0]);
                    feb13.setTime(tokens[1]);
                    feb13.setAway(tokens[2]);
                    feb13.setHome(tokens[3]);
                    feb13.setHomeWin(tokens[4]);
                    feb13.setAwayWin(tokens[5]);
                    febThirteenSamples.add(feb13);
                }
                MatchesSample feb20 = new MatchesSample();
                if (tokens[0].contains("Feb 20 2020")) {
                    feb20.setDate(tokens[0]);
                    feb20.setTime(tokens[1]);
                    feb20.setAway(tokens[2]);
                    feb20.setHome(tokens[3]);
                    feb20.setHomeWin(tokens[4]);
                    feb20.setAwayWin(tokens[5]);
                    febTwentySamples.add(feb20);
                }
                MatchesSample feb21 = new MatchesSample();
                if (tokens[0].contains("Feb 21 2020")) {
                    feb21.setDate(tokens[0]);
                    feb21.setTime(tokens[1]);
                    feb21.setAway(tokens[2]);
                    feb21.setHome(tokens[3]);
                    feb21.setHomeWin(tokens[4]);
                    feb21.setAwayWin(tokens[5]);
                    feb21Samples.add(feb21);
                }
                MatchesSample feb22 = new MatchesSample();
                if (tokens[0].contains("Feb 22 2020")) {
                    feb22.setDate(tokens[0]);
                    feb22.setTime(tokens[1]);
                    feb22.setAway(tokens[2]);
                    feb22.setHome(tokens[3]);
                    feb22.setHomeWin(tokens[4]);
                    feb22.setAwayWin(tokens[5]);
                    feb22Samples.add(feb22);
                }
                MatchesSample feb23 = new MatchesSample();
                if (tokens[0].contains("Feb 23 2020")) {
                    feb23.setDate(tokens[0]);
                    feb23.setTime(tokens[1]);
                    feb23.setAway(tokens[2]);
                    feb23.setHome(tokens[3]);
                    feb23.setHomeWin(tokens[4]);
                    feb23.setAwayWin(tokens[5]);
                    feb23Samples.add(feb23);
                }
                MatchesSample feb24 = new MatchesSample();
                if (tokens[0].contains("Feb 24 2020")) {
                    feb24.setDate(tokens[0]);
                    feb24.setTime(tokens[1]);
                    feb24.setAway(tokens[2]);
                    feb24.setHome(tokens[3]);
                    feb24.setHomeWin(tokens[4]);
                    feb24.setAwayWin(tokens[5]);
                    feb24Samples.add(feb24);
                }
                MatchesSample feb25 = new MatchesSample();
                if (tokens[0].contains("Feb 25 2020")) {
                    feb25.setDate(tokens[0]);
                    feb25.setTime(tokens[1]);
                    feb25.setAway(tokens[2]);
                    feb25.setHome(tokens[3]);
                    feb25.setHomeWin(tokens[4]);
                    feb25.setAwayWin(tokens[5]);
                    feb25Samples.add(feb25);
                }
                MatchesSample feb26 = new MatchesSample();
                if (tokens[0].contains("Feb 26 2020")) {
                    feb26.setDate(tokens[0]);
                    feb26.setTime(tokens[1]);
                    feb26.setAway(tokens[2]);
                    feb26.setHome(tokens[3]);
                    feb26.setHomeWin(tokens[4]);
                    feb26.setAwayWin(tokens[5]);
                    feb26Samples.add(feb26);
                }
                MatchesSample feb27 = new MatchesSample();
                if (tokens[0].contains("Feb 27 2020")) {
                    feb27.setDate(tokens[0]);
                    feb27.setTime(tokens[1]);
                    feb27.setAway(tokens[2]);
                    feb27.setHome(tokens[3]);
                    feb27.setHomeWin(tokens[4]);
                    feb27.setAwayWin(tokens[5]);
                    feb27Samples.add(feb27);
                }
                MatchesSample feb28 = new MatchesSample();
                if (tokens[0].contains("Feb 28 2020")) {
                    feb28.setDate(tokens[0]);
                    feb28.setTime(tokens[1]);
                    feb28.setAway(tokens[2]);
                    feb28.setHome(tokens[3]);
                    feb28.setHomeWin(tokens[4]);
                    feb28.setAwayWin(tokens[5]);
                    feb28Samples.add(feb28);
                }
                //***********MARCH***************
                MatchesSample marchOne = new MatchesSample();
                if (tokens[0].contains("Mar 1 2020")) {
                    marchOne.setDate(tokens[0]);
                    marchOne.setTime(tokens[1]);
                    marchOne.setAway(tokens[2]);
                    marchOne.setHome(tokens[3]);
                    marchOne.setHomeWin(tokens[4]);
                    marchOne.setAwayWin(tokens[5]);
                    marchOneSamples.add(marchOne);
                }
                MatchesSample marchTwo = new MatchesSample();
                if (tokens[0].contains("Mar 2 2020")) {
                    marchTwo.setDate(tokens[0]);
                    marchTwo.setTime(tokens[1]);
                    marchTwo.setAway(tokens[2]);
                    marchTwo.setHome(tokens[3]);
                    marchTwo.setHomeWin(tokens[4]);
                    marchTwo.setAwayWin(tokens[5]);
                    marchTwoSamples.add(marchTwo);
                }
                MatchesSample marchThree = new MatchesSample();
                if (tokens[0].contains("Mar 3 2020")) {
                    marchThree.setDate(tokens[0]);
                    marchThree.setTime(tokens[1]);
                    marchThree.setAway(tokens[2]);
                    marchThree.setHome(tokens[3]);
                    marchThree.setHomeWin(tokens[4]);
                    marchThree.setAwayWin(tokens[5]);
                    marchThreeSamples.add(marchThree);
                }
                MatchesSample marchFour = new MatchesSample();
                if (tokens[0].contains("Mar 4 2020")) {
                    marchFour.setDate(tokens[0]);
                    marchFour.setTime(tokens[1]);
                    marchFour.setAway(tokens[2]);
                    marchFour.setHome(tokens[3]);
                    marchFour.setHomeWin(tokens[4]);
                    marchFour.setAwayWin(tokens[5]);
                    marchFourSamples.add(marchFour);
                }
                MatchesSample marchFive = new MatchesSample();
                if (tokens[0].contains("Mar 5 2020")) {
                    marchFive.setDate(tokens[0]);
                    marchFive.setTime(tokens[1]);
                    marchFive.setAway(tokens[2]);
                    marchFive.setHome(tokens[3]);
                    marchFive.setHomeWin(tokens[4]);
                    marchFive.setAwayWin(tokens[5]);
                    marchFiveSamples.add(marchFive);
                }
                MatchesSample marchSix = new MatchesSample();
                if (tokens[0].contains("Mar 6 2020")) {
                    marchSix.setDate(tokens[0]);
                    marchSix.setTime(tokens[1]);
                    marchSix.setAway(tokens[2]);
                    marchSix.setHome(tokens[3]);
                    marchSix.setHomeWin(tokens[4]);
                    marchSix.setAwayWin(tokens[5]);
                    marchSixSamples.add(marchSix);
                }
                MatchesSample marchSeven = new MatchesSample();
                if (tokens[0].contains("Mar 7 2020")) {
                    marchSeven.setDate(tokens[0]);
                    marchSeven.setTime(tokens[1]);
                    marchSeven.setAway(tokens[2]);
                    marchSeven.setHome(tokens[3]);
                    marchSeven.setHomeWin(tokens[4]);
                    marchSeven.setAwayWin(tokens[5]);
                    marchSevenSamples.add(marchSeven);
                }
                MatchesSample marchEight = new MatchesSample();
                if (tokens[0].contains("Mar 8 2020")) {
                    marchEight.setDate(tokens[0]);
                    marchEight.setTime(tokens[1]);
                    marchEight.setAway(tokens[2]);
                    marchEight.setHome(tokens[3]);
                    marchEight.setHomeWin(tokens[4]);
                    marchEight.setAwayWin(tokens[5]);
                    marchEightSamples.add(marchEight);
                }
                MatchesSample marchNine = new MatchesSample();
                if (tokens[0].contains("Mar 9 2020")) {
                    marchNine.setDate(tokens[0]);
                    marchNine.setTime(tokens[1]);
                    marchNine.setAway(tokens[2]);
                    marchNine.setHome(tokens[3]);
                    marchNine.setHomeWin(tokens[4]);
                    marchNine.setAwayWin(tokens[5]);
                    marchNineSamples.add(marchNine);
                }
                MatchesSample marchTen = new MatchesSample();
                if (tokens[0].contains("Mar 10 2020")) {
                    marchTen.setDate(tokens[0]);
                    marchTen.setTime(tokens[1]);
                    marchTen.setAway(tokens[2]);
                    marchTen.setHome(tokens[3]);
                    marchTen.setHomeWin(tokens[4]);
                    marchTen.setAwayWin(tokens[5]);
                    marchTenSamples.add(marchTen);
                }
                MatchesSample marchEleven = new MatchesSample();
                if (tokens[0].contains("Mar 11 2020")) {
                    marchEleven.setDate(tokens[0]);
                    marchEleven.setTime(tokens[1]);
                    marchEleven.setAway(tokens[2]);
                    marchEleven.setHome(tokens[3]);
                    marchEleven.setHomeWin(tokens[4]);
                    marchEleven.setAwayWin(tokens[5]);
                    marchElevenSamples.add(marchEleven);
                }

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}

