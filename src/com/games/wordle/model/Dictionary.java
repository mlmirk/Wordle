package com.games.wordle.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary implements Serializable {


    private static final String dataFilePath= "data/wordleData.csv";


    private Map<Integer,String> wordMap= getDictionaryInstance();

    public Map<Integer, String> getDictionaryInstance() {
        Map<Integer,String > wordleMap= new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFilePath));
            for (String line: lines) {
                String[] tokens= line.split(",");
                Integer id= Integer.valueOf(tokens[0]);
                String name= tokens[1];
                wordleMap.put(id,name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordleMap;
    }

    public String getSecretWord(int index){
        return wordMap.get(index);
    }
    //refactor to other class
    public void saveName(String name){
       wordMap.put(15000, name);
    }
    public String loadName(){
        return wordMap.get(15000);
    }

    public void saveWins(int wins){
        wordMap.put(15001, String.valueOf(wins));
    }
    public int setSavedWins(){
        String savedWins= wordMap.get(15001);
        return Integer.parseInt(savedWins);
    }

    public void saveIndex(int index){
        wordMap.put(15002, String.valueOf(index))  ;
    }

    public int setSavedIndex(){
        String savedIndex= wordMap.get(15002);
        return Integer.parseInt(savedIndex);
    }

    public boolean isValidWord(String guess){
        if (wordMap.containsValue(guess)) {
            return true;
        }
        return false;
    }




    public void saveOver() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))){
            out.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




   /* public void dump(){
        System.out.println(wordMap);
    }
*/
}
