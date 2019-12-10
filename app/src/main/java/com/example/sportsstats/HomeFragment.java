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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalLayoutManager;
import devs.mulham.horizontalcalendar.model.CalendarEvent;
import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

import static android.icu.util.Calendar.DATE;

public class HomeFragment extends Fragment {

    TextView textView;
    ListView listView;
    Calendar instanceDate;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home,container, false);
       // final ViewTwo = inflater.inflate(R.layout.fragment_home,container, false);

        //sam[ple text view
        textView = (TextView) view.findViewById(R.id.textView);
        //List view
        listView =(ListView) view.findViewById(R.id.matchesList);


        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -2);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 6);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();



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
                //Date test = date.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

                String userDate = dateFormat.format(currDate.getTime());


                Log.d("MyActivity", "CLICKED DATE " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");
                //Log.d("MyActivity", "DATEFORMAT CURR DATE " + dateFormat.format(currDate.DATE + "\n\n\n\n\n@@@@@@@@@@\n\n"));
                int x = Integer.parseInt(userDate);
                if(x == 9){


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

                if(x == 10){


                    Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");

                        //arrayadapter
                        ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                                getActivity(),
                                android.R.layout.simple_list_item_1,
                                matchesSamples
                        );

                        //tell list view to use adapter for screen
                        listView.setAdapter(listViewAdapter);

                        Log.d("MyActivity", "x = 10 " + matchesSamples);
                       // inflater.inflate(R.layout.the_child_view, parent);


                    // listView.addView(   )

                }


                if(x == 11){


                    Log.d("MyActivity", "Date Selected " + userDate  + "\n\n\n\n\n@@@@@@@@@@\n\n");

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








                /*

                    //arrayadapter
                    ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                            getActivity(),
                            android.R.layout.simple_list_item_1,
                            matchesSamples
                    );

                    //tell list view to use adapter for screen
                    listView.setAdapter(listViewAdapter);
                if(date == 11){
                    //arrayadapter
                    ArrayAdapter<MatchesSample> listViewAdapter = new ArrayAdapter<MatchesSample>(
                            getActivity(),
                            android.R.layout.simple_list_item_1,
                            decemberElevenSamples
                    );

                    //tell list view to use adapter for screen
                    listView.setAdapter(listViewAdapter);

                }
                */
            }
        });

        //return inflater.inflate(R.layout.fragment_home, null);
        Log.d("MyActivity", "VIEW ID:" + view);
        return view;

    }







        List<MatchesSample> matchesSamples = new ArrayList<>();
        List<MatchesSample> decemberElevenSamples = new ArrayList<>();
        List<MatchesSample> decemberNineSamples = new ArrayList<>();



    private void readMatchesData(){
        InputStream inputStream = getResources().openRawResource(R.raw.december2019);
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
                    MatchesSample decemberTen = new MatchesSample();
                    MatchesSample decemberEleven = new MatchesSample();
                MatchesSample decemberNine = new MatchesSample();



                //MatchesSample novemberSchedule = new MatchesSample();

                //dec 9
                if(tokens[0].contains("Dec 9 2019")) {
                    decemberNine.setDate(tokens[0]);
                    decemberNine.setTime(tokens[1]);
                    decemberNine.setAway(tokens[2]);
                    decemberNine.setHome(tokens[3]);
                    decemberNineSamples.add(decemberNine);
                }
                //dec 10
                if(tokens[0].contains("Dec 10 2019")) {
                    decemberTen.setDate(tokens[0]);
                    decemberTen.setTime(tokens[1]);
                    decemberTen.setAway(tokens[2]);
                    decemberTen.setHome(tokens[3]);
                    matchesSamples.add(decemberTen);
                }

                //dec 11
                if(tokens[0].contains("Dec 11 2019")){
                    decemberEleven.setDate(tokens[0]);
                    decemberEleven.setTime(tokens[1]);
                    decemberEleven.setAway(tokens[2]);
                    decemberEleven.setHome(tokens[3]);
                    decemberElevenSamples.add(decemberEleven);
                }





                //Log.d("MyActivity", "Just Created: " + decemberSchedule);

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}

