package com.vc.hard;

import java.util.*;

class WordBreakIi {
    private HashMap<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);

        memo.put(s.length(), Collections.singletonList(""));
        return helper(s, 0, words);
    }

    private List<String> helper(String s, int from, HashSet<String> words) {
        if(memo.containsKey(from)) return memo.get(from);

        List<String> subRes = new ArrayList<>();
        for(int len = 1; from + len <= s.length(); len++) {
            String prefix = s.substring(from, from + len);
            if(words.contains(prefix)) {
                List<String> remaining = helper(s, from + len, words);
                for(String remainingStr: remaining) {
                    String output = remainingStr.length() > 0 ? prefix + " " + remainingStr : prefix;
                    subRes.add(output);
                }
            }
        }
        memo.put(from, subRes);
        return subRes;
    }
}