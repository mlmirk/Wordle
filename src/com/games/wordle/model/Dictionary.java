package com.games.wordle.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary{
    private static final String dataFilePath = "data/wordleData.csv";
    private Map<Integer, String> wordMap = getDictionaryInstance();

    public Map<Integer, String> getDictionaryInstance() {
        Map<Integer, String> wordMap = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFilePath));
            for (String line : lines) {
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                wordMap.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordMap;
    }

    public String getSecretWord(int index) {
        return wordMap.get(index);
    }

    public boolean isValidWord(String guess) {
        if (wordMap.containsValue(guess)) {
            return true;
        }
        return false;
    }
}


