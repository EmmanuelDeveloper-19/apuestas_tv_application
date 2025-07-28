package com.example.apuestas_app.models;

import java.io.Serializable;
import java.util.Date;

public class Match implements Serializable {
    private String teamAName;
    private int teamALogoResId;
    private int teamAGoals;

    private String teamBName;
    private int teamBLogoResId;
    private int teamBGoals;

    private double betAmount;
    private String matchDescription;

    private Date date;

    // Constructur par ainicializar un objeto
    public Match(String teamAName, int teamALogoResId, int teamAGoals, String teamBName, int teamBLogoResId, int teamBGoals, double betAmount, String matchDescription, Date date) {
        this.teamAName = teamAName;
        this.teamALogoResId = teamALogoResId;
        this.teamAGoals = teamAGoals;
        this.teamBName = teamBName;
        this.teamBLogoResId = teamBLogoResId;
        this.teamBGoals = teamBGoals;
        this.betAmount = betAmount;
        this.matchDescription = matchDescription;
        this.date = date;
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

    public int getTeamAGoals() {
        return teamAGoals;
    }

    public void setTeamAGoals(int teamAGoals) {
        this.teamAGoals = teamAGoals;
    }

    public int getTeamBGoals() {
        return teamBGoals;
    }

    public void setTeamBGoals(int teamBGoals) {
        this.teamBGoals = teamBGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
