package com.example.sportsstats;

class playerSample {
    private String player;
    private String position;
    private double fieldGoalPercent;
    private double freeThrowpercent;
    private double threePointersPerGame;
    private double pointsPerGame;
    private double reboundsPerGame;
    private double assistPerGame;
    private double stealsPerGame;
    private double blocksPerGame;
    private double turnoversPerGame;

    public String getPlayer(){
        return player;
    }
    public void setPlayer(String player){
        this.player = player;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public double getFieldGoalPercent(){
        return fieldGoalPercent;
    }
    public void setFieldGoalPercent(double fieldGoalPercent){
        this.fieldGoalPercent = fieldGoalPercent;
    }
    public double getFreeThrowpercent(){
        return freeThrowpercent;
    }
    public void setFreeThrowpercent(double freeThrowpercent){
        this.freeThrowpercent = freeThrowpercent;
    }


    public double getThreePointersPerGame(){
        return threePointersPerGame;
    }
    public void setThreePointersPerGame(double threePointersPerGame){
        this.threePointersPerGame = threePointersPerGame;
    }

    public double getPointsPerGame(){
        return pointsPerGame;
    }
    public void setPointsPerGame(double pointsPerGame){
        this.pointsPerGame = pointsPerGame;
    }

    public double getReboundsPerGame(){
        return reboundsPerGame;
    }
    public void setReboundsPerGame(double reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    public double getAssistPerGame(){
        return assistPerGame;
    }
    public void setAssistPerGame(double assistPerGame){
        this.assistPerGame = assistPerGame;
    }

    public double getStealsPerGame(){
        return stealsPerGame;
    }
    public void setStealsPerGame(double stealsPerGame){
        this.stealsPerGame = stealsPerGame;
    }

    public double getBlocksPerGame(){
        return blocksPerGame;
    }
    public void setBlocksPerGame(double blocksPerGame){
        this.blocksPerGame = blocksPerGame;
    }

    public double getTurnoversPerGame(){
        return turnoversPerGame;
    }
    public void setTurnoversPerGame(double turnoversPerGame){
        this.turnoversPerGame = turnoversPerGame;
    }

    @Override
    public String toString() {
        return "playerSample{" +
                "player='" + player + '\'' +
                ", position='" + position + '\'' +
                ", fieldGoalPercent=" + fieldGoalPercent +
                ", freeThrowpercent=" + freeThrowpercent +
                ", threePointersPerGame=" + threePointersPerGame +
                ", pointsPerGame=" + pointsPerGame +
                ", reboundsPerGame=" + reboundsPerGame +
                ", assistPerGame=" + assistPerGame +
                ", stealsPerGame=" + stealsPerGame +
                ", blocksPerGame=" + blocksPerGame +
                ", turnoversPerGame=" + turnoversPerGame +
                '}';
    }

}
