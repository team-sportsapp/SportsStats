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
    //int i;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home,container, false);

        //sample text view
        textView = (TextView) view.findViewById(R.id.textView);
        //List view
        listView =(ListView) view.findViewById(R.id.matchesList);


        /* starts before 7 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -7);

        /* ends after 4 month from now */
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
                    if (x == 22) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o22Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 23) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o23Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 24) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o24Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 25) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o25Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 26) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o26Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 27) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o27Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 28) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o28Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 29) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o29Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 30) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o30Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 31) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                o31Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                }

                //************NOVEMBER*****************
                if(currMonth == 11){
                    if (x == 1) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n1Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 2) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n2Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 3) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n3Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 4) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n4Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 5) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n5Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 6) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n6Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 7) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n7Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 8) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n8Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 9) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n9Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n10Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 11) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n11Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 12) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n12Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 13) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n13Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 14) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n14Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 15) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n15Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 16) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n16Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 17) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n17Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 18) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n18Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 19) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n19Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 20) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n20Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 21) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n21Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 22) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n22Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 23) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n23Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 24) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n24Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 25) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n25Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 26) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n26Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 27) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n27Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 29) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n29Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 30) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                n30Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                }

                //december
                if(currMonth == 12) {
                    if (x == 1) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j1Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 2) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d2Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 3) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d3Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 4) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d4Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 5) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d5Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 6) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d6Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 7) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d7Samples
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
                    if (x == 12) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d12Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 13) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d13Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 14) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d14Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
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
                    if (x == 16) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d16Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 17) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d17Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 18) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d18Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 19) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d19Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 20) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d20Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 21) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d21Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 22) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d22Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 23) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d23Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 25) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d25Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 26) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d26Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 27) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d27Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 28) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d28Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }if (x == 29) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d29Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 30) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d30Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 31) {
                        Log.d("MyActivity", "Date Selected " + userDate + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                d31Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }

                }

                //january
                if(currMonth == 1){
                    if (x == 1) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j1Samples
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
                                j2Samples
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
                                j3Samples
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
                                j4Samples
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
                                j5Samples
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
                                j6Samples
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
                                j7Samples
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
                                j8Samples
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
                                j9Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }if (x == 10) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j10Samples
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
                                j11Samples
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
                                j12Samples
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
                                j13Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 14) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j14Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 15) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j15Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 16) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j16Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 17) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j17Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 18) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j18Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 19) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j19Samples
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
                                j20Samples
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
                                j21Samples
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
                                j22Samples
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
                                j23Samples
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
                                j24Samples
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
                                j25Samples
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
                                j26Samples
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
                                j27Samples
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
                                j28Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 29) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j29Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 30) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j30Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }
                    if (x == 31) {
                        Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                j31Samples
                        );
                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);
                    }


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
        List<MatchesSample> o22Samples = new ArrayList<>();
        List<MatchesSample> o23Samples = new ArrayList<>();
        List<MatchesSample> o24Samples = new ArrayList<>();
        List<MatchesSample> o25Samples = new ArrayList<>();
        List<MatchesSample> o26Samples = new ArrayList<>();
        List<MatchesSample> o27Samples = new ArrayList<>();
        List<MatchesSample> o28Samples = new ArrayList<>();
        List<MatchesSample> o29Samples = new ArrayList<>();
        List<MatchesSample> o30Samples = new ArrayList<>();
        List<MatchesSample> o31Samples = new ArrayList<>();

        //november
        List<MatchesSample> n1Samples = new ArrayList<>();
        List<MatchesSample> n2Samples = new ArrayList<>();
        List<MatchesSample> n3Samples = new ArrayList<>();
        List<MatchesSample> n4Samples = new ArrayList<>();
        List<MatchesSample> n5Samples = new ArrayList<>();
        List<MatchesSample> n6Samples = new ArrayList<>();
        List<MatchesSample> n7Samples = new ArrayList<>();
        List<MatchesSample> n8Samples = new ArrayList<>();
        List<MatchesSample> n9Samples = new ArrayList<>();
        List<MatchesSample> n10Samples = new ArrayList<>();
        List<MatchesSample> n11Samples = new ArrayList<>();
        List<MatchesSample> n12Samples = new ArrayList<>();
        List<MatchesSample> n13Samples = new ArrayList<>();
        List<MatchesSample> n14Samples = new ArrayList<>();
        List<MatchesSample> n15Samples = new ArrayList<>();
        List<MatchesSample> n16Samples = new ArrayList<>();
        List<MatchesSample> n17Samples = new ArrayList<>();
        List<MatchesSample> n18Samples = new ArrayList<>();
        List<MatchesSample> n19Samples = new ArrayList<>();
        List<MatchesSample> n20Samples = new ArrayList<>();
        List<MatchesSample> n21Samples = new ArrayList<>();
        List<MatchesSample> n22Samples = new ArrayList<>();
        List<MatchesSample> n23Samples = new ArrayList<>();
        List<MatchesSample> n24Samples = new ArrayList<>();
        List<MatchesSample> n25Samples = new ArrayList<>();
        List<MatchesSample> n26Samples = new ArrayList<>();
        List<MatchesSample> n27Samples = new ArrayList<>();
        List<MatchesSample> n29Samples = new ArrayList<>();
        List<MatchesSample> n30Samples = new ArrayList<>();

        //december
        List<MatchesSample> d1Samples = new ArrayList<>();
        List<MatchesSample> d2Samples = new ArrayList<>();
        List<MatchesSample> d3Samples = new ArrayList<>();
        List<MatchesSample> d4Samples = new ArrayList<>();
        List<MatchesSample> d5Samples = new ArrayList<>();
        List<MatchesSample> d6Samples = new ArrayList<>();
        List<MatchesSample> d7Samples = new ArrayList<>();
        List<MatchesSample> decemberEightSamples = new ArrayList<>();
        List<MatchesSample> decemberNineSamples = new ArrayList<>();
        List<MatchesSample> decemberTenSamples = new ArrayList<>();
        List<MatchesSample> decemberElevenSamples = new ArrayList<>();
        List<MatchesSample> d12Samples = new ArrayList<>();
        List<MatchesSample> d13Samples = new ArrayList<>();
        List<MatchesSample> d14Samples = new ArrayList<>();
        List<MatchesSample> decemberFifteenthSamples = new ArrayList<>();
        List<MatchesSample> d16Samples = new ArrayList<>();
        List<MatchesSample> d17Samples = new ArrayList<>();
        List<MatchesSample> d18Samples = new ArrayList<>();
        List<MatchesSample> d19Samples = new ArrayList<>();
        List<MatchesSample> d20Samples = new ArrayList<>();
        List<MatchesSample> d21Samples = new ArrayList<>();
        List<MatchesSample> d22Samples = new ArrayList<>();
        List<MatchesSample> d23Samples = new ArrayList<>();
        List<MatchesSample> d25Samples = new ArrayList<>();
        List<MatchesSample> d26Samples = new ArrayList<>();
        List<MatchesSample> d27Samples = new ArrayList<>();
        List<MatchesSample> d28Samples = new ArrayList<>();
        List<MatchesSample> d29Samples = new ArrayList<>();
        List<MatchesSample> d30Samples = new ArrayList<>();
        List<MatchesSample> d31Samples = new ArrayList<>();

        //january
        List<MatchesSample> j1Samples = new ArrayList<>();
        List<MatchesSample> j2Samples = new ArrayList<>();
        List<MatchesSample> j3Samples = new ArrayList<>();
        List<MatchesSample> j4Samples = new ArrayList<>();
        List<MatchesSample> j5Samples = new ArrayList<>();
        List<MatchesSample> j6Samples = new ArrayList<>();
        List<MatchesSample> j7Samples = new ArrayList<>();
        List<MatchesSample> j8Samples = new ArrayList<>();
        List<MatchesSample> j9Samples = new ArrayList<>();
        List<MatchesSample> j10Samples = new ArrayList<>();
        List<MatchesSample> j11Samples = new ArrayList<>();
        List<MatchesSample> j12Samples = new ArrayList<>();
        List<MatchesSample> j13Samples = new ArrayList<>();
        List<MatchesSample> j14Samples = new ArrayList<>();
        List<MatchesSample> j15Samples = new ArrayList<>();
        List<MatchesSample> j16Samples = new ArrayList<>();
        List<MatchesSample> j17Samples = new ArrayList<>();
        List<MatchesSample> j18Samples = new ArrayList<>();
        List<MatchesSample> j19Samples = new ArrayList<>();
        List<MatchesSample> j20Samples = new ArrayList<>();
        List<MatchesSample> j21Samples = new ArrayList<>();
        List<MatchesSample> j22Samples = new ArrayList<>();
        List<MatchesSample> j23Samples = new ArrayList<>();
        List<MatchesSample> j24Samples = new ArrayList<>();
        List<MatchesSample> j25Samples = new ArrayList<>();
        List<MatchesSample> j26Samples = new ArrayList<>();
        List<MatchesSample> j27Samples = new ArrayList<>();
        List<MatchesSample> j28Samples = new ArrayList<>();
        List<MatchesSample> j29Samples = new ArrayList<>();
        List<MatchesSample> j30Samples = new ArrayList<>();
        List<MatchesSample> j31Samples = new ArrayList<>();

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
                //***********OCTOBER*************
                MatchesSample o22 = new MatchesSample();
                if (tokens[0].contains("Oct 22 2019")) {
                    o22.setDate(tokens[0]);
                    o22.setTime(tokens[1]);
                    o22.setAway(tokens[2]);
                    o22.setHome(tokens[3]);
                    o22.setHomeWin(tokens[4]);
                    o22.setAwayWin(tokens[5]);
                    o22Samples.add(o22);
                }
                MatchesSample o23 = new MatchesSample();
                if (tokens[0].contains("Oct 23 2019")) {
                    o23.setDate(tokens[0]);
                    o23.setTime(tokens[1]);
                    o23.setAway(tokens[2]);
                    o23.setHome(tokens[3]);
                    o23.setHomeWin(tokens[4]);
                    o23.setAwayWin(tokens[5]);
                    o23Samples.add(o23);
                }
                MatchesSample o24 = new MatchesSample();
                if (tokens[0].contains("Oct 24 2019")) {
                    o24.setDate(tokens[0]);
                    o24.setTime(tokens[1]);
                    o24.setAway(tokens[2]);
                    o24.setHome(tokens[3]);
                    o24.setHomeWin(tokens[4]);
                    o24.setAwayWin(tokens[5]);
                    o24Samples.add(o24);
                }
                MatchesSample o25 = new MatchesSample();
                if (tokens[0].contains("Oct 25 2019")) {
                    o25.setDate(tokens[0]);
                    o25.setTime(tokens[1]);
                    o25.setAway(tokens[2]);
                    o25.setHome(tokens[3]);
                    o25.setHomeWin(tokens[4]);
                    o25.setAwayWin(tokens[5]);
                    o25Samples.add(o25);
                }
                MatchesSample o26 = new MatchesSample();
                if (tokens[0].contains("Oct 26 2019")) {
                    o26.setDate(tokens[0]);
                    o26.setTime(tokens[1]);
                    o26.setAway(tokens[2]);
                    o26.setHome(tokens[3]);
                    o26.setHomeWin(tokens[4]);
                    o26.setAwayWin(tokens[5]);
                    o26Samples.add(o26);
                }
                MatchesSample o27 = new MatchesSample();
                if (tokens[0].contains("Oct 27 2019")) {
                    o27.setDate(tokens[0]);
                    o27.setTime(tokens[1]);
                    o27.setAway(tokens[2]);
                    o27.setHome(tokens[3]);
                    o27.setHomeWin(tokens[4]);
                    o27.setAwayWin(tokens[5]);
                    o27Samples.add(o27);
                }
                MatchesSample o28 = new MatchesSample();
                if (tokens[0].contains("Oct 28 2019")) {
                    o28.setDate(tokens[0]);
                    o28.setTime(tokens[1]);
                    o28.setAway(tokens[2]);
                    o28.setHome(tokens[3]);
                    o28.setHomeWin(tokens[4]);
                    o28.setAwayWin(tokens[5]);
                    o28Samples.add(o28);
                }
                MatchesSample o29 = new MatchesSample();
                if (tokens[0].contains("Oct 29 2019")) {
                    o29.setDate(tokens[0]);
                    o29.setTime(tokens[1]);
                    o29.setAway(tokens[2]);
                    o29.setHome(tokens[3]);
                    o29.setHomeWin(tokens[4]);
                    o29.setAwayWin(tokens[5]);
                    o29Samples.add(o29);
                }
                MatchesSample o30 = new MatchesSample();
                if (tokens[0].contains("Oct 30 2019")) {
                    o30.setDate(tokens[0]);
                    o30.setTime(tokens[1]);
                    o30.setAway(tokens[2]);
                    o30.setHome(tokens[3]);
                    o30.setHomeWin(tokens[4]);
                    o30.setAwayWin(tokens[5]);
                    o30Samples.add(o30);
                }
                MatchesSample o31 = new MatchesSample();
                if (tokens[0].contains("Oct 31 2019")) {
                    o31.setDate(tokens[0]);
                    o31.setTime(tokens[1]);
                    o31.setAway(tokens[2]);
                    o31.setHome(tokens[3]);
                    o31.setHomeWin(tokens[4]);
                    o31.setAwayWin(tokens[5]);
                    o31Samples.add(o31);
                }

                //***********NOVEMBER*************
                MatchesSample n1 = new MatchesSample();
                if (tokens[0].contains("Nov 1 2019")) {
                    n1.setDate(tokens[0]);
                    n1.setTime(tokens[1]);
                    n1.setAway(tokens[2]);
                    n1.setHome(tokens[3]);
                    n1.setHomeWin(tokens[4]);
                    n1.setAwayWin(tokens[5]);
                    n1Samples.add(n1);
                }
                MatchesSample n2 = new MatchesSample();
                if (tokens[0].contains("Nov 2 2019")) {
                    n2.setDate(tokens[0]);
                    n2.setTime(tokens[1]);
                    n2.setAway(tokens[2]);
                    n2.setHome(tokens[3]);
                    n2.setHomeWin(tokens[4]);
                    n2.setAwayWin(tokens[5]);
                    n2Samples.add(n2);
                }
                MatchesSample n3 = new MatchesSample();
                if (tokens[0].contains("Nov 3 2019")) {
                    n3.setDate(tokens[0]);
                    n3.setTime(tokens[1]);
                    n3.setAway(tokens[2]);
                    n3.setHome(tokens[3]);
                    n3.setHomeWin(tokens[4]);
                    n3.setAwayWin(tokens[5]);
                    n3Samples.add(n3);
                }
                MatchesSample n4 = new MatchesSample();
                if (tokens[0].contains("Nov 4 2019")) {
                    n4.setDate(tokens[0]);
                    n4.setTime(tokens[1]);
                    n4.setAway(tokens[2]);
                    n4.setHome(tokens[3]);
                    n4.setHomeWin(tokens[4]);
                    n4.setAwayWin(tokens[5]);
                    n4Samples.add(n4);
                }
                MatchesSample n5 = new MatchesSample();
                if (tokens[0].contains("Nov 5 2019")) {
                    n5.setDate(tokens[0]);
                    n5.setTime(tokens[1]);
                    n5.setAway(tokens[2]);
                    n5.setHome(tokens[3]);
                    n5.setHomeWin(tokens[4]);
                    n5.setAwayWin(tokens[5]);
                    n5Samples.add(n5);
                }
                MatchesSample n6 = new MatchesSample();
                if (tokens[0].contains("Nov 6 2019")) {
                    n6.setDate(tokens[0]);
                    n6.setTime(tokens[1]);
                    n6.setAway(tokens[2]);
                    n6.setHome(tokens[3]);
                    n6.setHomeWin(tokens[4]);
                    n6.setAwayWin(tokens[5]);
                    n6Samples.add(n6);
                }
                MatchesSample n7 = new MatchesSample();
                if (tokens[0].contains("Nov 7 2019")) {
                    n7.setDate(tokens[0]);
                    n7.setTime(tokens[1]);
                    n7.setAway(tokens[2]);
                    n7.setHome(tokens[3]);
                    n7.setHomeWin(tokens[4]);
                    n7.setAwayWin(tokens[5]);
                    n7Samples.add(n7);
                }
                MatchesSample n8 = new MatchesSample();
                if (tokens[0].contains("Nov 8 2019")) {
                    n8.setDate(tokens[0]);
                    n8.setTime(tokens[1]);
                    n8.setAway(tokens[2]);
                    n8.setHome(tokens[3]);
                    n8.setHomeWin(tokens[4]);
                    n8.setAwayWin(tokens[5]);
                    n8Samples.add(n8);
                }
                MatchesSample n9 = new MatchesSample();
                if (tokens[0].contains("Nov 9 2019")) {
                    n9.setDate(tokens[0]);
                    n9.setTime(tokens[1]);
                    n9.setAway(tokens[2]);
                    n9.setHome(tokens[3]);
                    n9.setHomeWin(tokens[4]);
                    n9.setAwayWin(tokens[5]);
                    n9Samples.add(n9);
                }
                MatchesSample n10 = new MatchesSample();
                if (tokens[0].contains("Nov 10 2019")) {
                    n10.setDate(tokens[0]);
                    n10.setTime(tokens[1]);
                    n10.setAway(tokens[2]);
                    n10.setHome(tokens[3]);
                    n10.setHomeWin(tokens[4]);
                    n10.setAwayWin(tokens[5]);
                    n10Samples.add(n10);
                }
                MatchesSample n11 = new MatchesSample();
                if (tokens[0].contains("Nov 11 2019")) {
                    n11.setDate(tokens[0]);
                    n11.setTime(tokens[1]);
                    n11.setAway(tokens[2]);
                    n11.setHome(tokens[3]);
                    n11.setHomeWin(tokens[4]);
                    n11.setAwayWin(tokens[5]);
                    n11Samples.add(n11);
                }
                MatchesSample n12 = new MatchesSample();
                if (tokens[0].contains("Nov 12 2019")) {
                    n12.setDate(tokens[0]);
                    n12.setTime(tokens[1]);
                    n12.setAway(tokens[2]);
                    n12.setHome(tokens[3]);
                    n12.setHomeWin(tokens[4]);
                    n12.setAwayWin(tokens[5]);
                    n12Samples.add(n12);
                }
                MatchesSample n13 = new MatchesSample();
                if (tokens[0].contains("Nov 13 2019")) {
                    n13.setDate(tokens[0]);
                    n13.setTime(tokens[1]);
                    n13.setAway(tokens[2]);
                    n13.setHome(tokens[3]);
                    n13.setHomeWin(tokens[4]);
                    n13.setAwayWin(tokens[5]);
                    n13Samples.add(n13);
                }
                MatchesSample n14 = new MatchesSample();
                if (tokens[0].contains("Nov 14 2019")) {
                    n14.setDate(tokens[0]);
                    n14.setTime(tokens[1]);
                    n14.setAway(tokens[2]);
                    n14.setHome(tokens[3]);
                    n14.setHomeWin(tokens[4]);
                    n14.setAwayWin(tokens[5]);
                    n14Samples.add(n14);
                }
                MatchesSample n15 = new MatchesSample();
                if (tokens[0].contains("Nov 15 2019")) {
                    n15.setDate(tokens[0]);
                    n15.setTime(tokens[1]);
                    n15.setAway(tokens[2]);
                    n15.setHome(tokens[3]);
                    n15.setHomeWin(tokens[4]);
                    n15.setAwayWin(tokens[5]);
                    n15Samples.add(n15);
                }
                MatchesSample n16 = new MatchesSample();
                if (tokens[0].contains("Nov 16 2019")) {
                    n16.setDate(tokens[0]);
                    n16.setTime(tokens[1]);
                    n16.setAway(tokens[2]);
                    n16.setHome(tokens[3]);
                    n16.setHomeWin(tokens[4]);
                    n16.setAwayWin(tokens[5]);
                    n16Samples.add(n16);
                }
                MatchesSample n17 = new MatchesSample();
                if (tokens[0].contains("Nov 17 2019")) {
                    n17.setDate(tokens[0]);
                    n17.setTime(tokens[1]);
                    n17.setAway(tokens[2]);
                    n17.setHome(tokens[3]);
                    n17.setHomeWin(tokens[4]);
                    n17.setAwayWin(tokens[5]);
                    n17Samples.add(n17);
                }
                MatchesSample n18 = new MatchesSample();
                if (tokens[0].contains("Nov 18 2019")) {
                    n18.setDate(tokens[0]);
                    n18.setTime(tokens[1]);
                    n18.setAway(tokens[2]);
                    n18.setHome(tokens[3]);
                    n18.setHomeWin(tokens[4]);
                    n18.setAwayWin(tokens[5]);
                    n18Samples.add(n18);
                }
                MatchesSample n19 = new MatchesSample();
                if (tokens[0].contains("Nov 19 2019")) {
                    n19.setDate(tokens[0]);
                    n19.setTime(tokens[1]);
                    n19.setAway(tokens[2]);
                    n19.setHome(tokens[3]);
                    n19.setHomeWin(tokens[4]);
                    n19.setAwayWin(tokens[5]);
                    n19Samples.add(n19);
                }
                MatchesSample n20 = new MatchesSample();
                if (tokens[0].contains("Nov 20 2019")) {
                    n20.setDate(tokens[0]);
                    n20.setTime(tokens[1]);
                    n20.setAway(tokens[2]);
                    n20.setHome(tokens[3]);
                    n20.setHomeWin(tokens[4]);
                    n20.setAwayWin(tokens[5]);
                    n20Samples.add(n20);
                }
                MatchesSample n21 = new MatchesSample();
                if (tokens[0].contains("Nov 21 2019")) {
                    n21.setDate(tokens[0]);
                    n21.setTime(tokens[1]);
                    n21.setAway(tokens[2]);
                    n21.setHome(tokens[3]);
                    n21.setHomeWin(tokens[4]);
                    n21.setAwayWin(tokens[5]);
                    n21Samples.add(n21);
                }
                MatchesSample n22 = new MatchesSample();
                if (tokens[0].contains("Nov 22 2019")) {
                    n22.setDate(tokens[0]);
                    n22.setTime(tokens[1]);
                    n22.setAway(tokens[2]);
                    n22.setHome(tokens[3]);
                    n22.setHomeWin(tokens[4]);
                    n22.setAwayWin(tokens[5]);
                    n22Samples.add(n22);
                }
                MatchesSample n23 = new MatchesSample();
                if (tokens[0].contains("Nov 23 2019")) {
                    n23.setDate(tokens[0]);
                    n23.setTime(tokens[1]);
                    n23.setAway(tokens[2]);
                    n23.setHome(tokens[3]);
                    n23.setHomeWin(tokens[4]);
                    n23.setAwayWin(tokens[5]);
                    n23Samples.add(n23);
                }
                MatchesSample n24 = new MatchesSample();
                if (tokens[0].contains("Nov 24 2019")) {
                    n24.setDate(tokens[0]);
                    n24.setTime(tokens[1]);
                    n24.setAway(tokens[2]);
                    n24.setHome(tokens[3]);
                    n24.setHomeWin(tokens[4]);
                    n24.setAwayWin(tokens[5]);
                    n24Samples.add(n24);
                }
                MatchesSample n25 = new MatchesSample();
                if (tokens[0].contains("Nov 25 2019")) {
                    n25.setDate(tokens[0]);
                    n25.setTime(tokens[1]);
                    n25.setAway(tokens[2]);
                    n25.setHome(tokens[3]);
                    n25.setHomeWin(tokens[4]);
                    n25.setAwayWin(tokens[5]);
                    n25Samples.add(n25);
                }
                MatchesSample n26 = new MatchesSample();
                if (tokens[0].contains("Nov 26 2019")) {
                    n26.setDate(tokens[0]);
                    n26.setTime(tokens[1]);
                    n26.setAway(tokens[2]);
                    n26.setHome(tokens[3]);
                    n26.setHomeWin(tokens[4]);
                    n26.setAwayWin(tokens[5]);
                    n26Samples.add(n26);
                }
                MatchesSample n27 = new MatchesSample();
                if (tokens[0].contains("Nov 27 2019")) {
                    n27.setDate(tokens[0]);
                    n27.setTime(tokens[1]);
                    n27.setAway(tokens[2]);
                    n27.setHome(tokens[3]);
                    n27.setHomeWin(tokens[4]);
                    n27.setAwayWin(tokens[5]);
                    n27Samples.add(n27);
                }
                MatchesSample n29 = new MatchesSample();
                if (tokens[0].contains("Nov 29 2019")) {
                    n29.setDate(tokens[0]);
                    n29.setTime(tokens[1]);
                    n29.setAway(tokens[2]);
                    n29.setHome(tokens[3]);
                    n29.setHomeWin(tokens[4]);
                    n29.setAwayWin(tokens[5]);
                    n29Samples.add(n29);
                }
                MatchesSample n30 = new MatchesSample();
                if (tokens[0].contains("Nov 30 2019")) {
                    n30.setDate(tokens[0]);
                    n30.setTime(tokens[1]);
                    n30.setAway(tokens[2]);
                    n30.setHome(tokens[3]);
                    n30.setHomeWin(tokens[4]);
                    n30.setAwayWin(tokens[5]);
                    n30Samples.add(n30);
                }

                //***********DECEMBER*************
                MatchesSample d1 = new MatchesSample();
                if (tokens[0].contains("Dec 1 2019")) {
                    d1.setDate(tokens[0]);
                    d1.setTime(tokens[1]);
                    d1.setAway(tokens[2]);
                    d1.setHome(tokens[3]);
                    d1.setHomeWin(tokens[4]);
                    d1.setAwayWin(tokens[5]);
                    d1Samples.add(d1);
                }
                MatchesSample d2 = new MatchesSample();
                if (tokens[0].contains("Dec 2 2019")) {
                    d2.setDate(tokens[0]);
                    d2.setTime(tokens[1]);
                    d2.setAway(tokens[2]);
                    d2.setHome(tokens[3]);
                    d2.setHomeWin(tokens[4]);
                    d2.setAwayWin(tokens[5]);
                    d2Samples.add(d2);
                }
                MatchesSample d3 = new MatchesSample();
                if (tokens[0].contains("Dec 3 2019")) {
                    d3.setDate(tokens[0]);
                    d3.setTime(tokens[1]);
                    d3.setAway(tokens[2]);
                    d3.setHome(tokens[3]);
                    d3.setHomeWin(tokens[4]);
                    d3.setAwayWin(tokens[5]);
                    d3Samples.add(d3);
                }
                MatchesSample d4 = new MatchesSample();
                if (tokens[0].contains("Dec 4 2019")) {
                    d4.setDate(tokens[0]);
                    d4.setTime(tokens[1]);
                    d4.setAway(tokens[2]);
                    d4.setHome(tokens[3]);
                    d4.setHomeWin(tokens[4]);
                    d4.setAwayWin(tokens[5]);
                    d4Samples.add(d4);
                }
                MatchesSample d5 = new MatchesSample();
                if (tokens[0].contains("Dec 5 2019")) {
                    d5.setDate(tokens[0]);
                    d5.setTime(tokens[1]);
                    d5.setAway(tokens[2]);
                    d5.setHome(tokens[3]);
                    d5.setHomeWin(tokens[4]);
                    d5.setAwayWin(tokens[5]);
                    d5Samples.add(d5);
                }
                MatchesSample d6 = new MatchesSample();
                if (tokens[0].contains("Dec 6 2019")) {
                    d6.setDate(tokens[0]);
                    d6.setTime(tokens[1]);
                    d6.setAway(tokens[2]);
                    d6.setHome(tokens[3]);
                    d6.setHomeWin(tokens[4]);
                    d6.setAwayWin(tokens[5]);
                    d6Samples.add(d6);
                }
                MatchesSample d7 = new MatchesSample();
                if (tokens[0].contains("Dec 7 2019")) {
                    d7.setDate(tokens[0]);
                    d7.setTime(tokens[1]);
                    d7.setAway(tokens[2]);
                    d7.setHome(tokens[3]);
                    d7.setHomeWin(tokens[4]);
                    d7.setAwayWin(tokens[5]);
                    d7Samples.add(d7);
                }
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
                MatchesSample d12 = new MatchesSample();
                if (tokens[0].contains("Dec 12 2019")) {
                    d12.setDate(tokens[0]);
                    d12.setTime(tokens[1]);
                    d12.setAway(tokens[2]);
                    d12.setHome(tokens[3]);
                    d12.setHomeWin(tokens[4]);
                    d12.setAwayWin(tokens[5]);
                    d12Samples.add(d12);
                }
                MatchesSample d13 = new MatchesSample();
                if (tokens[0].contains("Dec 13 2019")) {
                    d13.setDate(tokens[0]);
                    d13.setTime(tokens[1]);
                    d13.setAway(tokens[2]);
                    d13.setHome(tokens[3]);
                    d13.setHomeWin(tokens[4]);
                    d13.setAwayWin(tokens[5]);
                    d13Samples.add(d13);
                }
                MatchesSample d14 = new MatchesSample();
                if (tokens[0].contains("Dec 14 2019")) {
                    d14.setDate(tokens[0]);
                    d14.setTime(tokens[1]);
                    d14.setAway(tokens[2]);
                    d14.setHome(tokens[3]);
                    d14.setHomeWin(tokens[4]);
                    d14.setAwayWin(tokens[5]);
                    d14Samples.add(d14);
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
                MatchesSample d16 = new MatchesSample();
                if (tokens[0].contains("Dec 16 2019")) {
                    d16.setDate(tokens[0]);
                    d16.setTime(tokens[1]);
                    d16.setAway(tokens[2]);
                    d16.setHome(tokens[3]);
                    d16.setHomeWin(tokens[4]);
                    d16.setAwayWin(tokens[5]);
                    d16Samples.add(d16);
                }
                MatchesSample d17 = new MatchesSample();
                if (tokens[0].contains("Dec 17 2019")) {
                    d17.setDate(tokens[0]);
                    d17.setTime(tokens[1]);
                    d17.setAway(tokens[2]);
                    d17.setHome(tokens[3]);
                    d17.setHomeWin(tokens[4]);
                    d17.setAwayWin(tokens[5]);
                    d17Samples.add(d17);
                }
                MatchesSample d18 = new MatchesSample();
                if (tokens[0].contains("Dec 18 2019")) {
                    d18.setDate(tokens[0]);
                    d18.setTime(tokens[1]);
                    d18.setAway(tokens[2]);
                    d18.setHome(tokens[3]);
                    d18.setHomeWin(tokens[4]);
                    d18.setAwayWin(tokens[5]);
                    d18Samples.add(d18);
                }
                MatchesSample d19 = new MatchesSample();
                if (tokens[0].contains("Dec 19 2019")) {
                    d19.setDate(tokens[0]);
                    d19.setTime(tokens[1]);
                    d19.setAway(tokens[2]);
                    d19.setHome(tokens[3]);
                    d19.setHomeWin(tokens[4]);
                    d19.setAwayWin(tokens[5]);
                    d19Samples.add(d19);
                }
                MatchesSample d20 = new MatchesSample();
                if (tokens[0].contains("Dec 20 2019")) {
                    d20.setDate(tokens[0]);
                    d20.setTime(tokens[1]);
                    d20.setAway(tokens[2]);
                    d20.setHome(tokens[3]);
                    d20.setHomeWin(tokens[4]);
                    d20.setAwayWin(tokens[5]);
                    d20Samples.add(d20);
                }
                MatchesSample d21 = new MatchesSample();
                if (tokens[0].contains("Dec 21 2019")) {
                    d21.setDate(tokens[0]);
                    d21.setTime(tokens[1]);
                    d21.setAway(tokens[2]);
                    d21.setHome(tokens[3]);
                    d21.setHomeWin(tokens[4]);
                    d21.setAwayWin(tokens[5]);
                    d21Samples.add(d21);
                }
                MatchesSample d22 = new MatchesSample();
                if (tokens[0].contains("Dec 22 2019")) {
                    d22.setDate(tokens[0]);
                    d22.setTime(tokens[1]);
                    d22.setAway(tokens[2]);
                    d22.setHome(tokens[3]);
                    d22.setHomeWin(tokens[4]);
                    d22.setAwayWin(tokens[5]);
                    d22Samples.add(d22);
                }
                MatchesSample d23 = new MatchesSample();
                if (tokens[0].contains("Dec 23 2019")) {
                    d23.setDate(tokens[0]);
                    d23.setTime(tokens[1]);
                    d23.setAway(tokens[2]);
                    d23.setHome(tokens[3]);
                    d23.setHomeWin(tokens[4]);
                    d23.setAwayWin(tokens[5]);
                    d23Samples.add(d23);
                }
                MatchesSample d25 = new MatchesSample();
                if (tokens[0].contains("Dec 25 2019")) {
                    d25.setDate(tokens[0]);
                    d25.setTime(tokens[1]);
                    d25.setAway(tokens[2]);
                    d25.setHome(tokens[3]);
                    d25.setHomeWin(tokens[4]);
                    d25.setAwayWin(tokens[5]);
                    d25Samples.add(d25);
                }
                MatchesSample d26 = new MatchesSample();
                if (tokens[0].contains("Dec 26 2019")) {
                    d26.setDate(tokens[0]);
                    d26.setTime(tokens[1]);
                    d26.setAway(tokens[2]);
                    d26.setHome(tokens[3]);
                    d26.setHomeWin(tokens[4]);
                    d26.setAwayWin(tokens[5]);
                    d26Samples.add(d26);
                }
                MatchesSample d27 = new MatchesSample();
                if (tokens[0].contains("Dec 27 2019")) {
                    d27.setDate(tokens[0]);
                    d27.setTime(tokens[1]);
                    d27.setAway(tokens[2]);
                    d27.setHome(tokens[3]);
                    d27.setHomeWin(tokens[4]);
                    d27.setAwayWin(tokens[5]);
                    d27Samples.add(d27);
                }
                MatchesSample d28 = new MatchesSample();
                if (tokens[0].contains("Dec 28 2019")) {
                    d28.setDate(tokens[0]);
                    d28.setTime(tokens[1]);
                    d28.setAway(tokens[2]);
                    d28.setHome(tokens[3]);
                    d28.setHomeWin(tokens[4]);
                    d28.setAwayWin(tokens[5]);
                    d28Samples.add(d28);
                }
                MatchesSample d29 = new MatchesSample();
                if (tokens[0].contains("Dec 29 2019")) {
                    d29.setDate(tokens[0]);
                    d29.setTime(tokens[1]);
                    d29.setAway(tokens[2]);
                    d29.setHome(tokens[3]);
                    d29.setHomeWin(tokens[4]);
                    d29.setAwayWin(tokens[5]);
                    d29Samples.add(d29);
                }
                MatchesSample d30 = new MatchesSample();
                if (tokens[0].contains("Dec 30 2019")) {
                    d30.setDate(tokens[0]);
                    d30.setTime(tokens[1]);
                    d30.setAway(tokens[2]);
                    d30.setHome(tokens[3]);
                    d30.setHomeWin(tokens[4]);
                    d30.setAwayWin(tokens[5]);
                    d30Samples.add(d30);
                }
                MatchesSample d31 = new MatchesSample();
                if (tokens[0].contains("Dec 31 2019")) {
                    d31.setDate(tokens[0]);
                    d31.setTime(tokens[1]);
                    d31.setAway(tokens[2]);
                    d31.setHome(tokens[3]);
                    d31.setHomeWin(tokens[4]);
                    d31.setAwayWin(tokens[5]);
                    d31Samples.add(d31);
                }


                //***********JANUARY*************
                MatchesSample j1 = new MatchesSample();
                if (tokens[0].contains("Jan 1 2020")) {
                    j1.setDate(tokens[0]);
                    j1.setTime(tokens[1]);
                    j1.setAway(tokens[2]);
                    j1.setHome(tokens[3]);
                    j1.setHomeWin(tokens[4]);
                    j1.setAwayWin(tokens[5]);
                    j1Samples.add(j1);
                }
                MatchesSample j2 = new MatchesSample();
                if (tokens[0].contains("Jan 2 2020")) {
                    j2.setDate(tokens[0]);
                    j2.setTime(tokens[1]);
                    j2.setAway(tokens[2]);
                    j2.setHome(tokens[3]);
                    j2.setHomeWin(tokens[4]);
                    j2.setAwayWin(tokens[5]);
                    j2Samples.add(j2);
                }
                MatchesSample j3 = new MatchesSample();
                if (tokens[0].contains("Jan 3 2020")) {
                    j3.setDate(tokens[0]);
                    j3.setTime(tokens[1]);
                    j3.setAway(tokens[2]);
                    j3.setHome(tokens[3]);
                    j3.setHomeWin(tokens[4]);
                    j3.setAwayWin(tokens[5]);
                    j3Samples.add(j3);
                }
                MatchesSample j4 = new MatchesSample();
                if (tokens[0].contains("Jan 4 2020")) {
                    j4.setDate(tokens[0]);
                    j4.setTime(tokens[1]);
                    j4.setAway(tokens[2]);
                    j4.setHome(tokens[3]);
                    j4.setHomeWin(tokens[4]);
                    j4.setAwayWin(tokens[5]);
                    j4Samples.add(j4);
                }MatchesSample j5 = new MatchesSample();
                if (tokens[0].contains("Jan 5 2020")) {
                    j5.setDate(tokens[0]);
                    j5.setTime(tokens[1]);
                    j5.setAway(tokens[2]);
                    j5.setHome(tokens[3]);
                    j5.setHomeWin(tokens[4]);
                    j5.setAwayWin(tokens[5]);
                    j5Samples.add(j5);
                }MatchesSample j6 = new MatchesSample();
                if (tokens[0].contains("Jan 6 2020")) {
                    j6.setDate(tokens[0]);
                    j6.setTime(tokens[1]);
                    j6.setAway(tokens[2]);
                    j6.setHome(tokens[3]);
                    j6.setHomeWin(tokens[4]);
                    j6.setAwayWin(tokens[5]);
                    j6Samples.add(j6);
                }
                MatchesSample j7 = new MatchesSample();
                if (tokens[0].contains("Jan 7 2020")) {
                    j7.setDate(tokens[0]);
                    j7.setTime(tokens[1]);
                    j7.setAway(tokens[2]);
                    j7.setHome(tokens[3]);
                    j7.setHomeWin(tokens[4]);
                    j7.setAwayWin(tokens[5]);
                    j7Samples.add(j7);
                }
                MatchesSample j8 = new MatchesSample();
                if (tokens[0].contains("Jan 8 2020")) {
                    j8.setDate(tokens[0]);
                    j8.setTime(tokens[1]);
                    j8.setAway(tokens[2]);
                    j8.setHome(tokens[3]);
                    j8.setHomeWin(tokens[4]);
                    j8.setAwayWin(tokens[5]);
                    j8Samples.add(j8);
                }
                MatchesSample j9 = new MatchesSample();
                if (tokens[0].contains("Jan 9 2020")) {
                    j9.setDate(tokens[0]);
                    j9.setTime(tokens[1]);
                    j9.setAway(tokens[2]);
                    j9.setHome(tokens[3]);
                    j9.setHomeWin(tokens[4]);
                    j9.setAwayWin(tokens[5]);
                    j9Samples.add(j9);
                }
                MatchesSample j10 = new MatchesSample();
                if (tokens[0].contains("Jan 10 2020")) {
                    j10.setDate(tokens[0]);
                    j10.setTime(tokens[1]);
                    j10.setAway(tokens[2]);
                    j10.setHome(tokens[3]);
                    j10.setHomeWin(tokens[4]);
                    j10.setAwayWin(tokens[5]);
                    j10Samples.add(j10);
                }MatchesSample j11 = new MatchesSample();
                if (tokens[0].contains("Jan 11 2020")) {
                    j11.setDate(tokens[0]);
                    j11.setTime(tokens[1]);
                    j11.setAway(tokens[2]);
                    j11.setHome(tokens[3]);
                    j11.setHomeWin(tokens[4]);
                    j11.setAwayWin(tokens[5]);
                    j11Samples.add(j11);
                }MatchesSample j12 = new MatchesSample();
                if (tokens[0].contains("Jan 12 2020")) {
                    j12.setDate(tokens[0]);
                    j12.setTime(tokens[1]);
                    j12.setAway(tokens[2]);
                    j12.setHome(tokens[3]);
                    j12.setHomeWin(tokens[4]);
                    j12.setAwayWin(tokens[5]);
                    j12Samples.add(j12);
                }MatchesSample j13 = new MatchesSample();
                if (tokens[0].contains("Jan 13 2020")) {
                    j13.setDate(tokens[0]);
                    j13.setTime(tokens[1]);
                    j13.setAway(tokens[2]);
                    j13.setHome(tokens[3]);
                    j13.setHomeWin(tokens[4]);
                    j13.setAwayWin(tokens[5]);
                    j13Samples.add(j13);
                }MatchesSample j14 = new MatchesSample();
                if (tokens[0].contains("Jan 14 2020")) {
                    j14.setDate(tokens[0]);
                    j14.setTime(tokens[1]);
                    j14.setAway(tokens[2]);
                    j14.setHome(tokens[3]);
                    j14.setHomeWin(tokens[4]);
                    j14.setAwayWin(tokens[5]);
                    j14Samples.add(j14);
                }MatchesSample j15 = new MatchesSample();
                if (tokens[0].contains("Jan 15 2020")) {
                    j15.setDate(tokens[0]);
                    j15.setTime(tokens[1]);
                    j15.setAway(tokens[2]);
                    j15.setHome(tokens[3]);
                    j15.setHomeWin(tokens[4]);
                    j15.setAwayWin(tokens[5]);
                    j15Samples.add(j15);
                }MatchesSample j16 = new MatchesSample();
                if (tokens[0].contains("Jan 16 2020")) {
                    j16.setDate(tokens[0]);
                    j16.setTime(tokens[1]);
                    j16.setAway(tokens[2]);
                    j16.setHome(tokens[3]);
                    j16.setHomeWin(tokens[4]);
                    j16.setAwayWin(tokens[5]);
                    j16Samples.add(j16);
                }
                MatchesSample j17 = new MatchesSample();
                if (tokens[0].contains("Jan 17 2020")) {
                    j17.setDate(tokens[0]);
                    j17.setTime(tokens[1]);
                    j17.setAway(tokens[2]);
                    j17.setHome(tokens[3]);
                    j17.setHomeWin(tokens[4]);
                    j17.setAwayWin(tokens[5]);
                    j17Samples.add(j17);
                }MatchesSample j18 = new MatchesSample();
                if (tokens[0].contains("Jan 18 2020")) {
                    j18.setDate(tokens[0]);
                    j18.setTime(tokens[1]);
                    j18.setAway(tokens[2]);
                    j18.setHome(tokens[3]);
                    j18.setHomeWin(tokens[4]);
                    j18.setAwayWin(tokens[5]);
                    j18Samples.add(j18);
                }MatchesSample j19 = new MatchesSample();
                if (tokens[0].contains("Jan 19 2020")) {
                    j19.setDate(tokens[0]);
                    j19.setTime(tokens[1]);
                    j19.setAway(tokens[2]);
                    j19.setHome(tokens[3]);
                    j19.setHomeWin(tokens[4]);
                    j19.setAwayWin(tokens[5]);
                    j19Samples.add(j19);
                }MatchesSample j20  = new MatchesSample();
                if (tokens[0].contains("Jan 20 2020")) {
                    j20.setDate(tokens[0]);
                    j20.setTime(tokens[1]);
                    j20.setAway(tokens[2]);
                    j20.setHome(tokens[3]);
                    j20.setHomeWin(tokens[4]);
                    j20.setAwayWin(tokens[5]);
                    j20Samples.add(j20);
                }MatchesSample j21 = new MatchesSample();
                if (tokens[0].contains("Jan 21 2020")) {
                    j21.setDate(tokens[0]);
                    j21.setTime(tokens[1]);
                    j21.setAway(tokens[2]);
                    j21.setHome(tokens[3]);
                    j21.setHomeWin(tokens[4]);
                    j21.setAwayWin(tokens[5]);
                    j21Samples.add(j21);
                }
                MatchesSample j22 = new MatchesSample();
                if (tokens[0].contains("Jan 22 2020")) {
                    j22.setDate(tokens[0]);
                    j22.setTime(tokens[1]);
                    j22.setAway(tokens[2]);
                    j22.setHome(tokens[3]);
                    j22.setHomeWin(tokens[4]);
                    j22.setAwayWin(tokens[5]);
                    j22Samples.add(j22);
                }MatchesSample j23 = new MatchesSample();
                if (tokens[0].contains("Jan 23 2020")) {
                    j23.setDate(tokens[0]);
                    j23.setTime(tokens[1]);
                    j23.setAway(tokens[2]);
                    j23.setHome(tokens[3]);
                    j23.setHomeWin(tokens[4]);
                    j23.setAwayWin(tokens[5]);
                    j23Samples.add(j23);
                }
                MatchesSample j24   = new MatchesSample();
                if (tokens[0].contains("Jan 24 2020")) {
                    j24.setDate(tokens[0]);
                    j24.setTime(tokens[1]);
                    j24.setAway(tokens[2]);
                    j24.setHome(tokens[3]);
                    j24.setHomeWin(tokens[4]);
                    j24.setAwayWin(tokens[5]);
                    j24Samples.add(j24);
                }MatchesSample j25 = new MatchesSample();
                if (tokens[0].contains("Jan 25 2020")) {
                    j25.setDate(tokens[0]);
                    j25.setTime(tokens[1]);
                    j25.setAway(tokens[2]);
                    j25.setHome(tokens[3]);
                    j25.setHomeWin(tokens[4]);
                    j25.setAwayWin(tokens[5]);
                    j25Samples.add(j25);
                }MatchesSample j26 = new MatchesSample();
                if (tokens[0].contains("Jan 26 2020")) {
                    j26.setDate(tokens[0]);
                    j26.setTime(tokens[1]);
                    j26.setAway(tokens[2]);
                    j26.setHome(tokens[3]);
                    j26.setHomeWin(tokens[4]);
                    j26.setAwayWin(tokens[5]);
                    j26Samples.add(j26);
                }
                MatchesSample j27 = new MatchesSample();
                if (tokens[0].contains("Jan 27 2020")) {
                    j27.setDate(tokens[0]);
                    j27.setTime(tokens[1]);
                    j27.setAway(tokens[2]);
                    j27.setHome(tokens[3]);
                    j27.setHomeWin(tokens[4]);
                    j27.setAwayWin(tokens[5]);
                    j27Samples.add(j27);
                }
                MatchesSample j28 = new MatchesSample();
                if (tokens[0].contains("Jan 28 2020")) {
                    j28.setDate(tokens[0]);
                    j28.setTime(tokens[1]);
                    j28.setAway(tokens[2]);
                    j28.setHome(tokens[3]);
                    j28.setHomeWin(tokens[4]);
                    j28.setAwayWin(tokens[5]);
                    j28Samples.add(j28);
                }MatchesSample j29 = new MatchesSample();
                if (tokens[0].contains("Jan 29 2020")) {
                    j29.setDate(tokens[0]);
                    j29.setTime(tokens[1]);
                    j29.setAway(tokens[2]);
                    j29.setHome(tokens[3]);
                    j29.setHomeWin(tokens[4]);
                    j29.setAwayWin(tokens[5]);
                    j29Samples.add(j29);
                }MatchesSample j30 = new MatchesSample();
                if (tokens[0].contains("Jan 30 2020")) {
                    j30.setDate(tokens[0]);
                    j30.setTime(tokens[1]);
                    j30.setAway(tokens[2]);
                    j30.setHome(tokens[3]);
                    j30.setHomeWin(tokens[4]);
                    j30.setAwayWin(tokens[5]);
                    j30Samples.add(j30);
                }
                MatchesSample j31 = new MatchesSample();
                if (tokens[0].contains("Jan 31 2020")) {
                    j31.setDate(tokens[0]);
                    j31.setTime(tokens[1]);
                    j31.setAway(tokens[2]);
                    j31.setHome(tokens[3]);
                    j31.setHomeWin(tokens[4]);
                    j31.setAwayWin(tokens[5]);
                    j31Samples.add(j31);
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

