package com.example.sportsstats;

public class MatchesSample{
    private String date;
    private String time;
    private String away;
    private String home;

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

    @Override
    public String toString() {
        return date + '\n' +
                time + '\n' +
                home + '\n' +
                away;

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