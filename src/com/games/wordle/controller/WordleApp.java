package com.games.wordle.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordleApp {
    private  Board board;
    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    private static final int wordLength = 5;
    private static final String bannerFilePath = "data/welcomeBanner.txt";
    private int numberOfTries = 0;
    private boolean isGameOver = false;



    public void execute(){
        welcome();
        Board board = Board.getInstance();
        board.show();
        board.show();
    }
    private void welcome(){
        try {
            String text = Files.readString(Path.of(bannerFilePath));
            System.out.println(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

/*    private void initBoard(){
        Board board = Board.getInstance();
        startGame();
//        board.Player.setName(playerName);
    }*/

    private void enterName(){
        System.out.println("Please enter your name: ");
        playerName = scanner.nextLine();
    }

    private void startGame(){
        board.show();
        board.show();
    }

//        System.out.println("Hey, You Found The Answer in " +  numberOfTries + " tries.");


//    private void displayWordleWord(){
//        Map<Dictionary, List<String>>availWords ;
//        String guessMap;
//    }
    private void quitGame(){

    }

}
