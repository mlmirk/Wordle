package com.games.wordle.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private static final String dataFilePath= "data/WordleWordList.csv";


    private final Map<Integer,String> wordMap= loadWordMap();

    private Map<Integer, String> loadWordMap() {
        Map<Integer,String > wordleMap= new HashMap<>();
        int id = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFilePath));
            for (String line: lines) {
                String[] tokens= line.split(",");
                Integer idKey= id;
                String name= tokens[0];
                wordleMap.put(idKey,name);
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordleMap;
    }

    public String getSecretWord(int index){
        String secret;
        secret=wordMap.get(index);
        return secret;
    }

   /* public void dump(){
        System.out.println(wordMap);
    }*/
}
