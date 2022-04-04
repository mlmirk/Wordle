package com.games.wordle.model;

public class Player {
    private final String name;
    private final int id;
    private int wins;
    private int gamesPlayed;

    public Player(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public void guess(String guess) {
         // Make a call to the board submitting the input guess
    }

    public double winPercentage() {
        return (double) getWins() / getGamesPlayed();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void updateGamesPlayed() {
        this.gamesPlayed++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", wins=" + wins +
                ", gamesPlayed=" + gamesPlayed +
                ", winPercentage= " + this.winPercentage() +
                '}';
    }
}
