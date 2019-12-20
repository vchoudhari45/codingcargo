package com.vc.hard;

import java.util.*;

class L425 {
    public List<List<String>> wordSquares(String[] words) {
        HashMap<String, List<String>> word = new HashMap<>();
        for(String w: words) {
            String prefix = "";
            for(int i = 0; i <= w.length(); i++) {
                prefix = w.substring(0, i);
                List<String> list = word.getOrDefault(prefix, new ArrayList<String>());
                list.add(w);
                word.put(prefix, list);
            }
        }
        //System.out.println(word);
        List<List<String>> res = new ArrayList<List<String>>();
        if(words.length == 0) return res;
        List<String> l = new ArrayList<String>();
        solve(0, words, word, words[0].length(), l, res);
        return res;
    }

    private void solve(int row, String[] words,
                       HashMap<String, List<String>> word,
                       int length, List<String> l, List<List<String>> res) {
        if(row == length) {
            res.add(new ArrayList<String>(l));
        }
        else {
            String prefix = "";
            for(String str: l) {
                prefix += str.charAt(row);
            }
            if(word.containsKey(prefix)) {
                List<String> wordsWithPrefix = word.get(prefix);
                for(String wordWithPrefix: wordsWithPrefix) {
                    l.add(wordWithPrefix);
                    solve(row + 1, words, word, length, l, res);
                    l.remove(l.size() - 1);
                }
            }
        }
    }
}