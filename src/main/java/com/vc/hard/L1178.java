package com.vc.hard;

import java.util.*;

class L1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < words.length; i++) {
            int key = 0;
            for(int j = 0; j < words[i].length(); j++) {
                key |= 1 << words[i].charAt(j) - 'a';
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < puzzles.length; i++) {
            int key = 0;
            int first = 1 << puzzles[i].charAt(0) - 'a';
            for(int j = 0; j < puzzles[i].length(); j++) {
                key |= 1 << puzzles[i].charAt(j) - 'a';
            }

            int subKey = key;
            int count = 0;
            while(subKey != 0) {
                if((subKey & first) == first) count += map.getOrDefault(subKey, 0);
                subKey = (subKey - 1) & key;
            }
            res.add(count);
        }
        return res;
    }
}
