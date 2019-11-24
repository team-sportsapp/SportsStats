package com.example.sportsstats;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class FantasyFragment extends Fragment {

    TableLayout table1;
    TableRow tablerow;
    TextView playerName, Position, fieldGoalPercent, points, threePointMakes, freeThrowPercent, rebounds, assist, steals ,blocks ,turnovers;

    private LinearLayout parentLinearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fantasy, container, false);
        Button addPlayer = v.findViewById(R.id.addPlayerBtn);// button to add a row
        table1 = v.findViewById(R.id.playerTable);// table

        playerName = v.findViewById(R.id.playerName);// table inserts
        Position = v.findViewById(R.id.position);
        table1.setColumnStretchable(0,true); // make all rows stretchable
        table1.setColumnStretchable(1,true);

        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context dis;
                tablerow = new TableRow(getActivity());

                playerName = new TextView(getActivity());
                Position = new TextView(getActivity());
                playerName.setText("0");
                playerName.setTextSize(15);
                playerName.setGravity(Gravity.CENTER);
                Position.setText("0");
                Position.setTextSize(15);
                Position.setGravity(Gravity.CENTER);
            }
        });

        return v;
    }

}