package com.games.wordle.controller;

import com.games.wordle.model.Dictionary;
import com.games.wordle.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WordleApp {
    private  Board board;
    private Scanner scanner = new Scanner(System.in);
    private static int index = 0;
    private static final String bannerFilePath = "data/welcomeBanner.txt";
    private int turns = 0;
    private boolean isGameOver = false;



    public void execute(){
        welcome();
        enterName();
        Board board = Board.getInstance();
        Dictionary dictionary = new Dictionary();
        getValidInput(dictionary);
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


    private void enterName(){
        System.out.println("Please enter your name: ");
        String playerName = scanner.nextLine();
        Player currentPlayer  = new Player(playerName);
    }


    private void getValidInput(Dictionary dictionary) {
        String playerInput = scanner.nextLine();
        while (!dictionary.isValidWord(playerInput) || playerInput.length() != 5 || !isGameOver) {
            System.out.println("Invalid input");
            playerInput = scanner.nextLine();
            if (dictionary.isValidWord(playerInput) && playerInput.length() == 5 && !isGameOver) {
                System.out.println("Valid word");
                break;
                // send this to the gues method, then redo start game? Maybe change startgame to just
                // be a method for turns...
            }
        }
    }

    public void gameOver(int turns, String playerInput) {
        if (turns == 5) {

        }
    }
//        System.out.println("Hey, You Found The Answer in " +  turns + " tries.");


//    private void displayWordleWord(){
//        Map<Dictionary, List<String>>availWords ;
//        String guessMap;
//    }
    private void quitGame(){

    }

}
