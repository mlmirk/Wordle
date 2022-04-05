package com.games.wordle.controller;

import com.games.wordle.model.Dictionary;
import com.games.wordle.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordleApp {
    private  Board board;
    private Scanner scanner = new Scanner(System.in);
    private static final int wordLength = 5;
    private static final String bannerFilePath = "data/welcomeBanner.txt";
    private int turns = 0;
    private boolean isGameOver = false;



    public void execute(){
        welcome();
        enterName();
        Board board = Board.getInstance();
        Dictionary dictionary = new Dictionary();
        startGame();

    }

    private void welcome(){
        try {
            String text = Files.readString(Path.of(bannerFilePath));
            System.out.println(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private void enterName(){
        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine();
        Player currentPlayer  = new Player(playerName);
    }


    private void startGame(){
        board.show();
        board.show();
    }

//        System.out.println("Hey, You Found The Answer in " +  turns + " tries.");


//    private void displayWordleWord(){
//        Map<Dictionary, List<String>>availWords ;
//        String guessMap;
//    }
    private void quitGame(){

    }

}
