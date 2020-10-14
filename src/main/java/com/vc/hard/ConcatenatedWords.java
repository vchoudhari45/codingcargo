package com.vc.hard;

import java.util.*;

class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(canForm(word, set)) res.add(word);
            set.add(word);
        }
        return res;
    }

    private boolean canForm(String word, HashSet<String> set) {
        if(set.isEmpty()) return false;
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}