package com.example.sportsstats;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/28/2017.
 */

public class FantasyFragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
    private TableLayout table;
    private TableRow tablerow;
    TextView tvPlayerName, tvPosition, tvFieldGoalPercent, tvPoints, tvThreePointMakes, tvFreeThrowPercent, tvRebounds, tvAssist, tvSteals, tvBlocks, tvTurnovers;
    TextView tvTeamFieldGoalPercent, tvTeamPoints, tvTeamThreePointMakes, tvTeamFreeThrowPercent, tvTeamRebounds, tvTeamAssist, tvTeamSteals, tvTeamBlocks, tvTeamTurnovers;
    String corPlayer= ""; String corPosition= "";

    private static DecimalFormat df = new DecimalFormat("0.00");

    EditText addplayer;

    int rowCounter = 0;
    double playerPoints = 0;
    double playerfieldGoalPercent = 0.00;
    double playerThrees = 0;
    double playerFreeThrowPercent = 0;
    double playerRebounds = 0;
    double playerAssist = 0;
    double playerSteals = 0;
    double playerBlocks = 0;
    double playerTurnovers = 0;

    double fgAvg = 0.0;
    double fgTotalPercent = 0.0;
    double ftTotalPercent = 0.0;
    double totalPoints = 0.0;
    double totalThreePointers = 0.0;
    double freeThrowAvg = 0.0;
    double totalRebounds = 0.0;
    double totalAssist = 0.0;
    double totalSteals = 0.0;
    double totalBlocks = 0.0;
    double totalTurnovers = 0.0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fantasy, container, false);
        btnTEST = (Button) view.findViewById(R.id.btnTest);
        table = (TableLayout) view.findViewById(R.id.table);
        tablerow = (TableRow) view.findViewById(R.id.tr1);
        addplayer = (EditText) view.findViewById(R.id.addPlayer);

        tvTeamPoints = (TextView) view.findViewById(R.id.teamPoints);
        tvTeamFieldGoalPercent = (TextView) view.findViewById(R.id.teamFieldGoalPercentage);
        tvTeamFreeThrowPercent = (TextView) view.findViewById(R.id.teamFreeThrowPercentage);
        tvTeamThreePointMakes = (TextView) view.findViewById(R.id.teamThreePointers);
        tvTeamRebounds = (TextView) view.findViewById(R.id.teamRebounds);
        tvTeamAssist = (TextView) view.findViewById(R.id.teamAssist);
        tvTeamSteals = (TextView) view.findViewById(R.id.teamSteals);
        tvTeamBlocks = (TextView) view.findViewById(R.id.teamBlocks);
        tvTeamTurnovers = (TextView) view.findViewById(R.id.teamTurnovers);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                corPlayer ="";
                String testName = addplayer.getText().toString();
                readPlayerData(testName);

                 if(corPlayer.equals("")) {
                    Toast.makeText(getActivity(), "Player Not Found", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Player Added", Toast.LENGTH_SHORT).show();
                    tablerow = new TableRow(getActivity());
                    tvPlayerName = new TextView(getActivity());
                    tvPlayerName.setText(corPlayer);
                    tvPlayerName.setTextSize(15);
                    tvPlayerName.setTextColor(Color.rgb(0,0,0));


                    tvPosition = new TextView(getActivity());
                    tvPosition.setText(corPosition);
                    tvPosition.setTextSize(15);
                    tvPosition.setTextColor(Color.rgb(0,0,0));

                    tvFieldGoalPercent = new TextView(getActivity());
                    tvFieldGoalPercent.setText(String.valueOf(playerfieldGoalPercent));
                    tvFieldGoalPercent.setTextSize(15);
                    tvFieldGoalPercent.setTextColor(Color.rgb(0,0,0));

                    tvThreePointMakes = new TextView(getActivity());
                    tvThreePointMakes.setText(String.valueOf(playerThrees));
                    tvThreePointMakes.setTextSize(15);
                    tvThreePointMakes.setTextColor(Color.rgb(0,0,0));

                    tvPoints = new TextView(getActivity());
                    tvPoints.setText(String.valueOf(playerPoints));
                    tvPoints.setTextSize(15);
                    tvPoints.setTextColor(Color.rgb(0,0,0));

                    tvFreeThrowPercent = new TextView(getActivity());
                    tvFreeThrowPercent.setText(String.valueOf(playerFreeThrowPercent));
                    tvFreeThrowPercent.setTextSize(15);
                    tvFreeThrowPercent.setTextColor(Color.rgb(0,0,0));

                    tvRebounds = new TextView(getActivity());
                    tvRebounds.setText(String.valueOf(playerRebounds));
                    tvRebounds.setTextSize(15);
                    tvRebounds.setTextColor(Color.rgb(0,0,0));

                    tvAssist = new TextView(getActivity());
                    tvAssist.setText(String.valueOf(playerAssist));
                    tvAssist.setTextSize(15);
                    tvAssist.setTextColor(Color.rgb(0,0,0));

                    tvSteals = new TextView(getActivity());
                    tvSteals.setText(String.valueOf(playerSteals));
                    tvSteals.setTextSize(15);
                    tvSteals.setTextColor(Color.rgb(0,0,0));

                    tvBlocks = new TextView(getActivity());
                    tvBlocks.setText(String.valueOf(playerBlocks));
                    tvBlocks.setTextSize(15);
                    tvBlocks.setTextColor(Color.rgb(0,0,0));

                    tvTurnovers = new TextView(getActivity());
                    tvTurnovers.setText(String.valueOf(playerTurnovers));
                    tvTurnovers.setTextSize(15);
                    tvTurnovers.setTextColor(Color.rgb(0,0,0));

                    tablerow.addView(tvPlayerName);
                    tablerow.addView(tvPosition);
                    tablerow.addView(tvFieldGoalPercent);
                    tablerow.addView(tvFreeThrowPercent);
                    tablerow.addView(tvThreePointMakes);
                    tablerow.addView(tvPoints);
                    tablerow.addView(tvRebounds);
                    tablerow.addView(tvAssist);
                    tablerow.addView(tvSteals);
                    tablerow.addView(tvBlocks);
                    tablerow.addView(tvTurnovers);
                    table.addView(tablerow);


                    rowCounter++;

                    fgTotalPercent = fgTotalPercent + playerfieldGoalPercent;
                    ftTotalPercent = ftTotalPercent + playerFreeThrowPercent;
                    fgAvg = fgTotalPercent / rowCounter;
                    fgAvg = Math.round(fgAvg * 100) / 100.0;
                    freeThrowAvg = ftTotalPercent / rowCounter;
                    freeThrowAvg = Math.round(freeThrowAvg * 100) / 100.0;
                    totalPoints = totalPoints + playerPoints;
                    totalPoints = Math.round(totalPoints * 100) / 100.0;
                    totalThreePointers = totalThreePointers + playerThrees;
                    totalThreePointers = Math.round(totalThreePointers * 100) / 100.0;
                    totalRebounds = totalRebounds + playerRebounds;
                    totalRebounds = Math.round(totalRebounds * 100) / 100.0;
                    totalAssist = totalAssist + playerAssist;
                    totalAssist = Math.round(totalAssist * 100) / 100.0;
                    totalSteals = totalSteals + playerSteals;
                    totalSteals = Math.round(totalSteals * 100) / 100.0;
                    totalBlocks = totalBlocks + playerBlocks;
                    totalBlocks = Math.round(totalBlocks * 100) / 100.0;
                    totalTurnovers = totalTurnovers + playerTurnovers;
                    totalTurnovers = Math.round(totalPoints * 100) / 100.0;

                    tvTeamPoints.setText(String.valueOf(totalPoints));
                    tvTeamFieldGoalPercent.setText(String.valueOf(fgAvg));
                    tvTeamFreeThrowPercent.setText(String.valueOf(freeThrowAvg));
                    tvTeamThreePointMakes.setText(String.valueOf(totalThreePointers));
                    tvTeamRebounds.setText(String.valueOf(totalRebounds));
                    tvTeamAssist.setText(String.valueOf(totalAssist));
                    tvTeamSteals.setText(String.valueOf(totalSteals));
                    tvTeamBlocks.setText(String.valueOf(totalBlocks));
                    tvTeamTurnovers.setText(String.valueOf(totalTurnovers));
                }
                }



        }
        );

        return view;


    }



    private List<playerSample> playerSamples = new ArrayList<>();

    private void readPlayerData(String correctPlayer) {
        InputStream is = getResources().openRawResource(R.raw.predictedstats);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";

        try{
            //step over header
            reader.readLine();
            while ((line = reader.readLine()) != null){
                Log.d("MyActivity", "Line: " + line);
                //split by commas
                String[] tokens = line.split(",");

                //read data
                playerSample player = new playerSample();
                //reader.readLine();

                player.setPlayer(tokens[0]);
                if(correctPlayer.equals (tokens[0]))
                { corPlayer = correctPlayer;
                  corPosition = tokens[1];
                    playerfieldGoalPercent =Double.parseDouble(tokens[2]);
                    playerFreeThrowPercent = Double.parseDouble(tokens[3]);
                    playerThrees = Double.parseDouble(tokens[4]);
                    playerPoints = Double.parseDouble(tokens[5]);
                    playerRebounds = Double.parseDouble(tokens[6]);
                    playerAssist = Double.parseDouble(tokens[7]);
                    playerSteals = Double.parseDouble(tokens[8]);
                    playerBlocks = Double.parseDouble(tokens[9]);
                    playerTurnovers = Double.parseDouble(tokens[10]);
                }


                if(tokens[1].length() > 0){
                    player.setPosition(tokens[1]); }
                else {player.setPosition("");}
                if(tokens[2].length()>0){
                    player.setFieldGoalPercent(Double.parseDouble(tokens[2]));}
                else {player.setFieldGoalPercent(0);}

                if(tokens[3].length()>0){
                    player.setFreeThrowpercent(Double.parseDouble(tokens[3])); }
                else {player.setFreeThrowpercent(0);}

                if(tokens[4].length()>0){
                    player.setThreePointersPerGame(Double.parseDouble(tokens[4]));}
                else {player.setThreePointersPerGame(0);}

                if(tokens[5].length()>0){
                    player.setPointsPerGame(Double.parseDouble(tokens[5]));}
                else {player.setPointsPerGame(0);}

                if(tokens[6].length()>0){
                    player.setReboundsPerGame(Double.parseDouble(tokens[6]));}
                else {player.setReboundsPerGame(0);}

                if(tokens[7].length()>0){
                    player.setAssistPerGame(Double.parseDouble(tokens[7]));}
                else {player.setAssistPerGame(0);}

                if(tokens[8].length()>0){
                    player.setStealsPerGame(Double.parseDouble(tokens[8]));}
                else {player.setStealsPerGame(0);}

                if(tokens[9].length()>0){
                    player.setBlocksPerGame(Double.parseDouble(tokens[9]));}
                else {player.setBlocksPerGame(0);}

                if(tokens.length>= 11 && tokens[10].length()>0){
                    player.setTurnoversPerGame(Double.parseDouble(tokens[10]));}
                else {player.setTurnoversPerGame(0);}

                playerSamples.add(player);
                Log.d("MyActivity", "Just Created: " + player);

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }
}
