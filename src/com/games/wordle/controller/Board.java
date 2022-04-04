package com.games.wordle.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Board implements Serializable {
    private static final String guessPath= "data/board.dat";
    private final Map<Integer,String[]> guessMap= new TreeMap<>();

    public static Board getInstance() {
        Board board = null;

        if(Files.exists(Paths.get(guessPath))){//data file exists
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(guessPath))){
                board = (Board) in.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            board = new Board();

        }
        return board;
    }

    public void fillMapTemplate(){
        for(int i =0 ; i < 6 ; i++){
            String[]temp= {"_","_","_","_","_"};
            guessMap.put(i,temp );
        }
    }

    public void updateBoard(int turn, String userGuess ){
        String[] temp = userGuess.split("");
        guessMap.put(turn,temp);
    }

   /* private void save() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(guessPath))){
            out.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public void show(){
        if(guessMap.isEmpty()){
            fillMapTemplate();
            } else {
            Collection<String[]> guesses = guessMap.values();
            for (String[] d : guesses) {//could use a for loop or something else to check and set colors
                System.out.println(Arrays.toString(d));
            }
        }
    }





}
