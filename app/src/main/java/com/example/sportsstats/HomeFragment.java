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

        /*
        final java.util.Calendar date;
        Calendar currDateWrapper = date;
        int currMonthWrapper = currDateWrapper.getTime().getMonth();
         */



        //load matches list
        readMatchesData();



/*
        //arrayadapter
        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                matchesSamples
        );




        //tell list view to use adapter for screen
        listView.setAdapter(listViewAdapter);

 */




        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(final java.util.Calendar date, int position) {


                //do something
                //Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!", Toast.LENGTH_SHORT).show();
                //String str = s

                Calendar currDate = date;
                Date test2 = currDate.getTime();
                int currMonth = currDate.getTime().getMonth();
                //add 1 to test3 so its not 0 through 11
                currMonth += 1;
                //Log.d("MyActivity", "CURRENT MONTH ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS: " + month);
                Log.d("MyActivity", "CURRENT MONTH FROM GET TIME IS........:" + test2);
                Log.d("MyActivity", "CURRENT MONTH FROM GET MONTH IS........:" + currMonth);
                //Date test = date.getTime();
               // Date monthTest = date.getMonth();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

                String userDate = dateFormat.format(currDate.getTime());


                Log.d("MyActivity", "CLICKED DATE " + userDate);
                //Log.d("MyActivity", "DATEFORMAT CURR DATE " + dateFormat.format(currDate.DATE + "\n\n\n\n\n@@@@@@@@@@\n\n"));
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
                    if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
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

