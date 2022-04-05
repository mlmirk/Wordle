package com.games.wordle.controller;

import java.util.*;

public class Board {

        private Map<Integer,String[]> guessMap= new TreeMap<>();


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
            if(guessMap.isEmpty()){ //put turn == 0 here rather than empty when connected
                fillMapTemplate();
            } else {
                Collection<String[]> guesses = guessMap.values();
                for (String[] d : guesses) {//could use a for loop or something else to check and set colors
                    System.out.println(Arrays.toString(d));
                }
            }
        }





    }



