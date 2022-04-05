package com.games.wordle.controller;

import com.games.wordle.model.Dictionary;
import com.games.wordle.model.Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordleApp {
    private  Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
    private static int index;
    private static final String bannerFilePath = "data/welcomeBanner.txt";
    private int turns = 0;
    private boolean isGameOver = false;
    private String secretWord;
    private Dictionary dict = new Dictionary();
    private String guess;
    //wordle app has a dictionary

    //It who has the data does the work

    public void execute(){
        welcome();
        enterName();
        board.show();
        secretWord = dict.getSecretWord(index);
        index++;

        while(!isGameOver){
        getValidInput();
        //board.show();
        gameOver(turns, guess);
        }



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



    private void getValidInput() {

       boolean isValid= false;
        do
        {
            System.out.println("Enter a 5 letter word: ");
            guess = scanner.nextLine().toLowerCase();
            if( guess.length() ==5 && dict.isValidWord(guess))
                isValid = true;
            else
                System.out.println("Not a valid word");
        } while (!isValid);
        turns++;
        wordChecker(guess, secretWord);

    }

    public void wordChecker(String guess, String secret) {
        boolean exists = false;
        secret = "hello";
        String[] secretArray = secret.split("");

        String[] guessArray = guess.split("");
        for (int i = 0; i < 5; i++) {
            if (secret.contains(guessArray[i])) {
                int current = secret.indexOf(guessArray[i],i);
                if (i == current) {
                    System.out.print(Color.GREEN_BACKGROUND + guessArray[i]);
                } else {
                    System.out.print(Color.YELLOW_BACKGROUND + guessArray[i]);
                }
            }else{
            System.out.print(Color.RED_BACKGROUND + guessArray[i]);
            }
            System.out.print(Color.RESET);


        }

    }




    public void gameOver(int turns, String playerInput) {
        if (turns == 6 || secretWord.equals(playerInput)) {
            isGameOver =true;
        }
    }

    private void quitGame(){

    }
}
