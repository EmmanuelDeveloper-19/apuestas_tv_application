package com.example.apuestas_app.models;

import java.io.Serializable;

public class Match implements Serializable {
    private String teamAName;
    private int teamALogoResId;
    private String teamBName;
    private int teamBLogoResId;

    private double betAmount;
    private String matchDescription;

    // Constructur par ainicializar un objeto
    public Match(String teamAName, int teamALogoResId, String teamBName, int teamBLogoResId, double betAmount, String matchDescription) {
        this.teamAName = teamAName;
        this.teamALogoResId = teamALogoResId;
        this.teamBName = teamBName;
        this.teamBLogoResId = teamBLogoResId;
        this.betAmount = betAmount;
        this.matchDescription = matchDescription;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public int getTeamALogoResId() {
        return teamALogoResId;
    }

    public void setTeamALogoResId(int teamALogoResId) {
        this.teamALogoResId = teamALogoResId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public int getTeamBLogoResId() {
        return teamBLogoResId;
    }

    public void setTeamBLogoResId(int teamBLogoResId) {
        this.teamBLogoResId = teamBLogoResId;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public void setMatchDescription(String matchDescription) {
        this.matchDescription = matchDescription;
    }
}
