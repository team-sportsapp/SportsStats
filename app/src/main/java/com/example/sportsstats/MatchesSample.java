package com.example.sportsstats;

public class MatchesSample{
    private String date;
    private String time;
    private String away;
    private String home;
    private String homeWin;
    private String awayWin;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHomeWin(){
        return homeWin;
    }

    public void setHomeWin(String homeWin){
        this.homeWin = homeWin;
    }
    public String getAwayWin(){
        return awayWin;
    }

    public void setAwayWin(String awayWin){
        this.awayWin = awayWin;
    }


    @Override
    public String toString() {
        return "Date: " + date + '\n' +
                "Time(EST): " + time + '\n' +
                "Home: " + home + "     Win Rate: " + homeWin  + '\n' +
                "Away: " + away + "     Win Rate: " + awayWin  ;

          /*
        return "MatchesSample{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", away='" + away + '\'' +
                ", home='" + home + '\'' +
                '}';

         */
    }
}