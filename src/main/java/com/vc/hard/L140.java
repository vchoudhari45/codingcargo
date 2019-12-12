package com.vc.hard;

import java.util.*;

class L140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        HashSet<String> words = new HashSet<>(wordDict);
        return solve(0, s, words, map);
    }

    private List<String> solve(int index, String s,
                               HashSet<String> words, HashMap<Integer, List<String>> map) {
        if(map.containsKey(index)) return map.get(index);
        List<String> res = new ArrayList<String>();
        for(int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);
            if(words.contains(word)) {
                List<String> sub = solve(i + 1, s, words, map);
                if(sub.size() == 0 && i + 1 >= s.length()) res.add(word);
                for(String str: sub) res.add(word+" "+str);
            }
        }
        map.put(index, res);
        return res;
    }
}
