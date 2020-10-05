package com.vc.hard;

import java.util.*;

class WordSquares {
    private HashMap<String, HashSet<String>> prefixMap;
    private List<List<String>> res;
    private String[] words;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.prefixMap = new HashMap<>();
        this.res = new ArrayList<>();

        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                HashSet<String> set = prefixMap.getOrDefault(prefix, new HashSet<>());
                set.add(word);
                prefixMap.put(prefix, set);
            }
        }
        helper(0, new ArrayList<>());
        return res;
    }

    private void helper(int row, List<String> wordList) {
        if(row == words[0].length()) res.add(new ArrayList<>(wordList));
        else {
            String prefix = "";
            for(String word: wordList) prefix += word.charAt(row);

            if(!prefixMap.containsKey(prefix)) return;

            for(String prefixWord: prefixMap.get(prefix)) {
                wordList.add(prefixWord);
                helper(row + 1, wordList);
                wordList.remove(wordList.size() - 1);
            }
        }
    }
}