package com.vc.hard;

import java.util.*;

class L30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<Integer>();

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //System.out.println(map);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i + words[0].length() <= s.length(); i++) {
            solve(s, words, i, words.length, words[0].length(), map, res);
        }
        return res;
    }

    private void solve(String s, String[] words,
                       int index, int count, int wordlen,
                       HashMap<String, Integer> map, List<Integer> res) {
        if(count == 0) {
            res.add(index - wordlen * words.length);
        }
        else {
            if(index + wordlen <= s.length()) {
                //System.out.println("index: "+index+" wordLen: "+wordlen+" length: "+s.length());
                String word = s.substring(index, index + wordlen);
                //System.out.println("Searching for word: "+word+" map: "+map);
                if(map.containsKey(word) && map.get(word) > 0) {
                    map.put(word, map.get(word) - 1);
                    solve(s, words, index + wordlen, count - 1, wordlen, map, res);
                    map.put(word, map.get(word) + 1);
                }
            }
        }
    }
}
