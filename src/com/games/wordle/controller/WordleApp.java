package com.games.wordle.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class WordleApp {
    private  Board board;
    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    private static final int wordLength = 5;
    private static final String bannerFilePath = "welcomeBanner.txt";



    public void execute(){
        welcome();

    }
    private void welcome(){
        try {
            String text = Files.readString(Path.of(bannerFilePath));
            System.out.println(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void initBoard(){
        board = new Board();
        String userInput = scanner.nextLine();
//        board.Player.setName(playerName);
    }

    private void enterName(){
        System.out.println("Please enter your name: ");
        playerName = scanner.nextLine();
    }

    private void startGame(){
        initBoard();
    }
    private void quitGame(){

    }

}
