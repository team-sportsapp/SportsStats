package com.example.sportsstats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportsstats.R;

/**
 * Created by User on 2/28/2017.
 */

public class FantasyFragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
    private TableLayout table;
    private TableRow tablerow;
    TextView playerName, position, fieldGoalPercent, points, threePointMakes, freeThrowPercent, rebounds, assist, steals ,blocks ,turnovers;
    EditText addplayer;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fantasy,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTest);
        table = (TableLayout) view.findViewById(R.id.table);
        tablerow = (TableRow) view.findViewById(R.id.tr1);
        //addplayer = (EditText) view.findViewById(R.id.addplayer);
        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView test = addplayer;
                Toast.makeText(getActivity(), "Player Added",Toast.LENGTH_SHORT).show();
                tablerow = new TableRow(getActivity());
                playerName = new TextView(getActivity());
                playerName.setText("auston");
                playerName.setTextSize(15);
                playerName.setGravity(Gravity.CENTER);

                position = new TextView(getActivity());
                position.setText("Pg");
                position.setTextSize(15);
                position.setGravity(Gravity.CENTER);

                fieldGoalPercent = new TextView(getActivity());
                fieldGoalPercent.setText("45");
                fieldGoalPercent.setTextSize(15);
                fieldGoalPercent.setGravity(Gravity.CENTER);

                threePointMakes = new TextView(getActivity());
                threePointMakes.setText("6");
                threePointMakes.setTextSize(15);
                threePointMakes.setGravity(Gravity.CENTER);

                points = new TextView(getActivity());
                points.setText("27");
                points.setTextSize(15);
                points.setGravity(Gravity.CENTER);

                freeThrowPercent = new TextView(getActivity());
                freeThrowPercent.setText("87");
                freeThrowPercent.setTextSize(15);
                freeThrowPercent.setGravity(Gravity.CENTER);

                rebounds = new TextView(getActivity());
                rebounds.setText("6");
                rebounds.setTextSize(15);
                rebounds.setGravity(Gravity.CENTER);

                assist = new TextView(getActivity());
                assist.setText("7");
                assist.setTextSize(15);
                assist.setGravity(Gravity.CENTER);

                steals = new TextView(getActivity());
                steals.setText("2.1");
                steals.setTextSize(15);
                steals.setGravity(Gravity.CENTER);

                blocks = new TextView(getActivity());
                blocks.setText("2.3");
                blocks.setTextSize(15);
                blocks.setGravity(Gravity.CENTER);

                turnovers = new TextView(getActivity());
                turnovers.setText("3");
                turnovers.setTextSize(15);
                turnovers.setGravity(Gravity.CENTER);






                tablerow.addView(playerName);
                tablerow.addView(position);
                tablerow.addView(fieldGoalPercent);
                tablerow.addView(freeThrowPercent);
                tablerow.addView(threePointMakes);
                tablerow.addView(points);
                tablerow.addView(rebounds);
                tablerow.addView(assist);
                tablerow.addView(steals);
                tablerow.addView(blocks);
                tablerow.addView(turnovers);
                table.addView(tablerow);
               // tablerow.addView(threePointMakes);
            }
        });

        return view;
    }
}