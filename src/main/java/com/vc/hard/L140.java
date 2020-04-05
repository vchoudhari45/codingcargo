package com.vc.hard;

import java.util.*;

class L140 {

    HashMap<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> r = new ArrayList<>();
        r.add("");

        memo.put(s.length(), r);
        return helper(s, 0, new HashSet<>(wordDict));
    }

    private List<String> helper(String s, int start, HashSet<String> dict) {

        if(memo.containsKey(start)) return memo.get(start);

        List<String> res = new ArrayList<>();
        for(int i = start + 1; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if(dict.contains(prefix)) {
                List<String> subWords = helper(s, i, dict);
                for(String subWord: subWords) {
                    res.add(prefix + (subWord.equals("") ? "": " ") + subWord);
                }
            }
        }

        memo.put(start, res);

        return res;
    }
}