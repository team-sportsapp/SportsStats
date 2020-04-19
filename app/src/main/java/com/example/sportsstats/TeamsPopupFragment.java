package com.example.sportsstats;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TeamsPopupFragment extends Fragment {

    public TeamsPopupFragment(){}

    TextView tvtTeamNamePop, tvtGamesPlayedPop, tvtFieldGoalPercentPop, tvtPointsPop, tvtThreePointsMadePop, tvtFreeThrowPercentPop, tvtReboundsPop, tvtAssistsPop, tvtStealsPop, tvtBlocksPop, tvtTurnoversPop;
    String teamName="";

    private static DecimalFormat df = new DecimalFormat("0.00");


    double gamesPlayed = 0;
    double teamFieldGoalPercent = 0.00;
    double teamThrees = 0;
    double teamPoints = 0;
    double teamFreeThrowPercent = 0;
    double teamRebounds = 0;
    double teamAssist = 0;
    double teamSteals = 0;
    double teamBlocks = 0;
    double teamTurnovers = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.players_popup, container, false);


        view.setBackgroundColor(Color.DKGRAY);
        teamName = getArguments().getString("Key");
        //textView.setText(key);


        readTeamDataPop(teamName);

        tvtTeamNamePop.setText(teamName);
        tvtTeamNamePop.setTextSize(30);
        tvtTeamNamePop.setTextColor(Color.rgb(0,0,0));

        tvtGamesPlayedPop.setText("GP: " +gamesPlayed);
        tvtGamesPlayedPop.setTextSize(20);
        tvtGamesPlayedPop.setTextColor(Color.rgb(0,0,0));

        tvtFieldGoalPercentPop.setText("FG %: " + String.valueOf(teamFieldGoalPercent));
        tvtFieldGoalPercentPop.setTextSize(20);
        tvtFieldGoalPercentPop.setTextColor(Color.rgb(0,0,0));

        tvtThreePointsMadePop.setText("3-Pointers: " +String.valueOf(teamThrees));
        tvtThreePointsMadePop.setTextSize(20);
        tvtThreePointsMadePop.setTextColor(Color.rgb(0,0,0));

        tvtPointsPop.setText("Points: " +String.valueOf(teamPoints));
        tvtPointsPop.setTextSize(20);
        tvtPointsPop.setTextColor(Color.rgb(0,0,0));

        tvtFreeThrowPercentPop.setText("FT %: " +String.valueOf(teamFreeThrowPercent));
        tvtFreeThrowPercentPop.setTextSize(20);
        tvtFreeThrowPercentPop.setTextColor(Color.rgb(0,0,0));

        tvtReboundsPop.setText("Rebounds: "+String.valueOf(teamRebounds));
        tvtReboundsPop.setTextSize(20);
        tvtReboundsPop.setTextColor(Color.rgb(0,0,0));

        tvtAssistsPop.setText("Assists: "+String.valueOf(teamAssist));
        tvtAssistsPop.setTextSize(20);
        tvtAssistsPop.setTextColor(Color.rgb(0,0,0));

        tvtStealsPop.setText("Steals: "+String.valueOf(teamSteals));
        tvtStealsPop.setTextSize(20);
        tvtStealsPop.setTextColor(Color.rgb(0,0,0));

        tvtBlocksPop.setText("Blocks: "+String.valueOf(teamBlocks));
        tvtBlocksPop.setTextSize(20);
        tvtBlocksPop.setTextColor(Color.rgb(0,0,0));

        tvtTurnoversPop.setText("Turnovers: "+String.valueOf(teamTurnovers));
        tvtTurnoversPop.setTextSize(20);
        tvtTurnoversPop.setTextColor(Color.rgb(0,0,0));

        return view;
    }

    private List<teamSample> teamSamples = new ArrayList<>();

    private void readTeamDataPop(String correctTeam) {
        InputStream is = getResources().openRawResource(R.raw.teamstats);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";

        try{
            //step over header
            reader.readLine();
            while ((line = reader.readLine()) != null){
                //Log.d("MyActivity", "Line: " + line);
                //split by commas
                String[] tokens = line.split(",");

                //read data
                teamSample team = new teamSample();
                reader.readLine();

                team.setTeam(tokens[0]);
                if(correctTeam.equals (tokens[0]))
                { teamName = correctTeam;
                    gamesPlayed = Double.parseDouble(tokens[1]);
                    teamFieldGoalPercent =Double.parseDouble(tokens[2]);
                    teamFreeThrowPercent = Double.parseDouble(tokens[3]);
                    teamThrees = Double.parseDouble(tokens[4]);
                    teamPoints = Double.parseDouble(tokens[5]);
                    teamRebounds = Double.parseDouble(tokens[6]);
                    teamAssist = Double.parseDouble(tokens[7]);
                    teamSteals = Double.parseDouble(tokens[8]);
                    teamBlocks = Double.parseDouble(tokens[9]);
                    teamTurnovers = Double.parseDouble(tokens[10]);
                }


                if(tokens[1].length() > 0){
                    team.setGamesPlayed(Double.parseDouble(tokens[1])); }
                else {team.setGamesPlayed(0);}
                if(tokens[2].length()>0){
                    team.setFieldGoalPercent(Double.parseDouble(tokens[2]));}
                else {team.setFieldGoalPercent(0);}

                if(tokens[3].length()>0){
                    team.setFreeThrowpercent(Double.parseDouble(tokens[3])); }
                else {team.setFreeThrowpercent(0);}

                if(tokens[4].length()>0){
                    team.setThreePointersPerGame(Double.parseDouble(tokens[4]));}
                else {team.setThreePointersPerGame(0);}

                if(tokens[5].length()>0){
                    team.setPointsPerGame(Double.parseDouble(tokens[5]));}
                else {team.setPointsPerGame(0);}

                if(tokens[6].length()>0){
                    team.setReboundsPerGame(Double.parseDouble(tokens[6]));}
                else {team.setReboundsPerGame(0);}

                if(tokens[7].length()>0){
                    team.setAssistPerGame(Double.parseDouble(tokens[7]));}
                else {team.setAssistPerGame(0);}

                if(tokens[8].length()>0){
                    team.setStealsPerGame(Double.parseDouble(tokens[8]));}
                else {team.setStealsPerGame(0);}

                if(tokens[9].length()>0){
                    team.setBlocksPerGame(Double.parseDouble(tokens[9]));}
                else {team.setBlocksPerGame(0);}

                if(tokens.length>= 11 && tokens[10].length()>0){
                    team.setTurnoversPerGame(Double.parseDouble(tokens[10]));}
                else {team.setTurnoversPerGame(0);}

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }
}
