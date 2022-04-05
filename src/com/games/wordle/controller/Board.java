package com.games.wordle.controller;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Board  {

        private final Map<Integer,String[]> guessMap= new TreeMap<>();

        public static com.games.wordle.controller.Board getInstance() {
            Board board = new com.games.wordle.controller.Board();
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


        public void show(){
            if(guessMap.isEmpty()){ //put turn == 0 here rather then empty when conectect
                fillMapTemplate();
            } else {
                Collection<String[]> guesses = guessMap.values();
                for (String[] d : guesses) {//could use a for loop or something else to check and set colors
                    System.out.println(Arrays.toString(d));
                }
            }
        }





    }



