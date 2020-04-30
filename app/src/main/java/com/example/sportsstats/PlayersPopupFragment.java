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

public class PlayersPopupFragment extends Fragment {

    public PlayersPopupFragment(){}

    TextView tvPlayerNamePop, tvPositionPop, tvFieldGoalPercentPop, tvThreePointMakesPop, tvPointsPop, tvFreeThrowPercentPop, tvReboundsPop, tvAssistPop, tvStealsPop, tvBlocksPop, tvTurnoversPop;
    String playerName= "";
    String playerPosition= "";

    private static DecimalFormat df = new DecimalFormat("0.00");

    double playerPoints = 0;
    double playerfieldGoalPercent = 0.00;
    double playerThrees = 0;
    double playerFreeThrowPercent = 0;
    double playerRebounds = 0;
    double playerAssist = 0;
    double playerSteals = 0;
    double playerBlocks = 0;
    double playerTurnovers = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.players_popup, container, false);

        //TextView textView = (TextView)view.findViewById(R.id.tvPlayerNamePop);
        view.setBackgroundColor(Color.WHITE);
        String playerName = getArguments().getString("Key"); //ex: key = "Adams, Steven"
        //textView.setText(key);

        //String[] nameArray = key.split(", "); // [Adams, Steven]
        //playerName = nameArray[1] + " " + nameArray[0]; // "Steven Adams"

        readPlayerDataPop(playerName);

        TextView pName = (TextView)view.findViewById(R.id.tvPlayerNamePop);
        //tvPlayerNamePop = new TextView(getActivity());
        pName.setText(playerName);
        pName.setTextSize(30);
        pName.setTextColor(Color.rgb(0,0,0));

        TextView posPop = (TextView)view.findViewById(R.id.tvPositionPop);
        posPop.setText("Position: " +playerPosition);
        posPop.setTextSize(20);
        posPop.setTextColor(Color.rgb(0,0,0));

        TextView fgPercent = (TextView)view.findViewById(R.id.tvFieldGoalPercentPop);
        fgPercent.setText("FG %: " + String.valueOf(playerfieldGoalPercent));
        fgPercent.setTextSize(20);
        fgPercent.setTextColor(Color.rgb(0,0,0));

        TextView tpMakes = (TextView)view.findViewById(R.id.tvThreePointMakesPop);
        tpMakes.setText("3-Pointers: " +String.valueOf(playerThrees));
        tpMakes.setTextSize(20);
        tpMakes.setTextColor(Color.rgb(0,0,0));

        TextView ptPop = (TextView)view.findViewById(R.id.tvPointsPop);
        ptPop.setText("Points: " +String.valueOf(playerPoints));
        ptPop.setTextSize(20);
        ptPop.setTextColor(Color.rgb(0,0,0));

        TextView ftPer = (TextView)view.findViewById(R.id.tvFreeThrowPercentPop);
        ftPer.setText("FT %: " +String.valueOf(playerFreeThrowPercent));
        ftPer.setTextSize(20);
        ftPer.setTextColor(Color.rgb(0,0,0));

        TextView reboundsPop = (TextView)view.findViewById(R.id.tvReboundsPop);
        reboundsPop.setText("Rebounds: "+String.valueOf(playerRebounds));
        reboundsPop.setTextSize(20);
        reboundsPop.setTextColor(Color.rgb(0,0,0));

        TextView assistPop = (TextView)view.findViewById(R.id.tvAssistPop);
        assistPop.setText("Assists: "+String.valueOf(playerAssist));
        assistPop.setTextSize(20);
        assistPop.setTextColor(Color.rgb(0,0,0));

        TextView stealPop = (TextView)view.findViewById(R.id.tvStealsPop);
        stealPop.setText("Steals: "+String.valueOf(playerSteals));
        stealPop.setTextSize(20);
        stealPop.setTextColor(Color.rgb(0,0,0));

        TextView blockPop = (TextView)view.findViewById(R.id.tvBlocksPop);
        blockPop.setText("Blocks: "+String.valueOf(playerBlocks));
        blockPop.setTextSize(20);
        blockPop.setTextColor(Color.rgb(0,0,0));

        TextView turnPop = (TextView)view.findViewById(R.id.tvTurnoversPop);
        turnPop.setText("Turnovers: "+String.valueOf(playerTurnovers));
        turnPop.setTextSize(20);
        turnPop.setTextColor(Color.rgb(0,0,0));

        return view;
    }

    private List<playerSample> playerSamples = new ArrayList<>();

    private void readPlayerDataPop(String correctPlayer) {
        InputStream is = getResources().openRawResource(R.raw.playerstatsas);
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
                playerSample player = new playerSample();
                //reader.readLine();

                player.setPlayer(tokens[0]);
                if(correctPlayer.equals (tokens[0]))
                { playerName = correctPlayer;
                    playerPosition = tokens[1];
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

            }
        }catch (IOException e){
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }

}
