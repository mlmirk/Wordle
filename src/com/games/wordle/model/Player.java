package com.games.wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int wins;
    private int gamesPlayed;
    private List<String> guesses = new ArrayList<>();
    private List<Integer> randomIndex = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   /* public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }*/

   /* public int getGamesPlayed() {
        return gamesPlayed;
    }*/

  /*  public void updateGamesPlayed() {
        this.gamesPlayed++;
    }*/

    public void insertGuesses(String guess){
        guesses.add(guess);
    }

    public List<String> getGuesses(){
        return guesses;
    }

    public void clearGuesses(){
        guesses.clear();
    }

    public boolean alreadyGuessed(String guess){
        if(guesses.contains(guess)){
            System.out.println("Word already guessed");
        }
        return !guesses.contains(guess);
    }

    public void insertIndexes(int index){
        randomIndex.add(index);
    }

    public boolean indexUsed(int index){
       return randomIndex.contains(index);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", gamesPlayed=" + gamesPlayed +
                '}';
    }
}