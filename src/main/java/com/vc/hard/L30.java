package com.vc.hard;

import java.util.*;

class L30 {
    private String s;
    private String[] words;
    private HashMap<String, Integer> wordMap = new HashMap<>();
    private List<Integer> res = new ArrayList<>();
    private int wordLength = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        this.words = words;

        //All the words have same length is a trick to solve this problem, put them into hashMap and backtrack
        if(words.length == 0) return res;
        else wordLength = words[0].length();

        for(String word: words) wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

        for(int i = 0; i + wordLength <= s.length(); i++)  solve(i, words.length);

        return res;
    }

    private void solve(int index, int pendingWords) {
        if(pendingWords == 0) {
            res.add(index - words.length * wordLength);
        }
        else {
            if(index + wordLength <= s.length()) {
                String currentIndexWord = s.substring(index, index + wordLength);
                if(wordMap.getOrDefault(currentIndexWord, 0) > 0) {
                    wordMap.put(currentIndexWord, wordMap.get(currentIndexWord) - 1);
                    solve(index + wordLength, pendingWords - 1);
                    wordMap.put(currentIndexWord, wordMap.get(currentIndexWord) + 1);
                }
            }
        }
    }
}