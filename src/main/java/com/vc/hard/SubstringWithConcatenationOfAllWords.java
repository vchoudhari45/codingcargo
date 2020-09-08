package com.vc.hard;

import java.util.*;

class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;

        HashMap<String, Integer> mapInitial = new HashMap<>();
        int required = 0;
        for(String word: words) {
            mapInitial.put(word, mapInitial.getOrDefault(word, 0) + 1);
            required++;
        }

        int wordLength = words[0].length();
        for(int i = 0; i + words.length * wordLength <= s.length(); i++) {
            HashMap<String, Integer> map = new HashMap<>();

            int total = 0;
            for(int j = i; j <= i + words.length * wordLength; j = j + wordLength) {
                //Fixed length word
                String word = s.substring(j, j + wordLength);

                //See if word is present in a words input array
                map.put(word, map.getOrDefault(word, 0) + 1);
                if(map.get(word) > mapInitial.getOrDefault(word, 0)) break;

                //If so see if we found all the elements in a input words array
                if(++total == required) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}