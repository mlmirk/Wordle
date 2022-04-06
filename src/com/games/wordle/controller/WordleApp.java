package com.games.wordle.controller;

import com.games.wordle.model.Dictionary;
import com.games.wordle.model.Player;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordleApp {
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
    private static final String bannerFilePath = "data/welcomeBanner.txt";
    private int turns = 0;
    private boolean isGameOver = false;
    private String secretWord;
    private Dictionary dict = new Dictionary();
    private String guess;
    Player currentPlayer;
    boolean hasPlayed = false;
    //wordle app has a dictionary

    //It who has the data does the work

    public void execute() {
        if (!hasPlayed) {
            welcome();
            enterName();
        }
        board.show();
        getSecretWord();
        System.out.println("Enter a 5 letter word: ");
        while (!isGameOver) {
            getValidInput();
            //board.show();
            gameOver(turns, guess);
        }


    }

    private void welcome() {
        try {
            String text = Files.readString(Path.of(bannerFilePath));
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSecretWord(){
        int index = (int) Math.floor(Math.random() * (12971 + 1) + 0);
        while(currentPlayer.indexUsed(index)){
           index = (int) Math.floor(Math.random() * (12971 + 1) + 0);
        }
        currentPlayer.insertIndexes(index);
        secretWord = dict.getSecretWord(index);
    }



    private void enterName() {
        System.out.println("Please enter your name: ");

        String playerName = scanner.nextLine();
        currentPlayer = new Player(playerName);
    }


    private void getValidInput() {

        boolean isValid = false;

        do {
            guess = scanner.nextLine().toLowerCase();
            if (guess.length() == 5 && dict.isValidWord(guess) && currentPlayer.alreadyGuessed(guess)) {
                isValid = true;
                turns++;
            } else
                System.out.println("Not a valid word ");
        } while (!isValid);
        currentPlayer.insertGuesses(guess);
        wordChecker(guess, secretWord);

    }

    public void wordChecker(String guess, String secret) {

        String[] guessArray = guess.split("");
        for (int i = 0; i < secret.length(); i++) {
            if (secret.contains(guessArray[i])) {
                int current = secret.indexOf(guessArray[i], i);
                if (i == current) {
                    String x = String.valueOf(guessArray[i]);
                    secret = secret.replaceFirst("" + x + "", "!");
                    System.out.print(Color.GREEN_BACKGROUND + guessArray[i]);
                } else {
                    System.out.print(Color.YELLOW_BACKGROUND + guessArray[i]);
                    String x = String.valueOf(guessArray[i]);
                    secret = secret.replaceFirst("" + x + "", "!");
                }
            } else {
                System.out.print(Color.RED_BACKGROUND + guessArray[i]);
            }
            System.out.print(Color.RESET);


        }

        System.out.println();
    }


    public void gameOver(int turns, String playerInput) {
        if (turns == 6 || secretWord.equals(playerInput)) {
            isGameOver = true;
            playAgain();
        }
    }
    private void playAgain() {

        System.out.print("Do you want to [P]lay again? Or [Q]uit game?   ");
        String options = scanner.nextLine().toUpperCase();
        switch (options) {
            case "P":
                hasPlayed = true;
                isGameOver=false;
                execute();
                break;
            case "Q":
                quitGame();
                break;
            default:
                playAgain();
        }
    }

        private void quitGame(){
            wordleSurvey();
        }


        private void wordleSurvey(){
            System.out.println("How did you like Wordle by MDN Wordle Docs ?  ");
            String survey = scanner.nextLine();
            System.out.println("Thank You! We now know you are Wurtley enough for the Wurtle Club..");
        }


}
