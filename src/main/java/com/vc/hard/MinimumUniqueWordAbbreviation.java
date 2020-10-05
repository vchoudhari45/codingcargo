package com.vc.hard;

import java.util.*;

class MinimumUniqueWordAbbreviation {
    public String minAbbreviation(String target, String[] dictionary) {
        int targetLength = target.length();

        //Calculate binary representation of string in a dictionary
        HashSet<Integer> diffs = new HashSet<>();
        for(String word: dictionary) {
            int diff = 0;
            if(word.length() == target.length()) {
                for(int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) != target.charAt(i)) {
                        //If character is different mark it as 1
                        diff += (1 << i);
                    }
                }
                diffs.add(diff);
            }
        }

        if(diffs.size() == 0) return String.valueOf(target.length());

        int winner = 0;
        int maxConsecutiveZeroCount = Integer.MIN_VALUE;
        //Choose the winner from all 2 ^ targetLength possibilities
        for(int cand = 0; cand < (1 << targetLength); cand++) {
            boolean isValid = true;
            for(int diff: diffs) {
                if((diff & cand) == 0) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                int consecutiveZeroCount = 0;
                for(int i = 0; i < targetLength - 1; i++) {
                    if(((cand >> i) & 3) == 0) consecutiveZeroCount++;
                }

                if(consecutiveZeroCount > maxConsecutiveZeroCount) {
                    maxConsecutiveZeroCount = consecutiveZeroCount;
                    winner = cand;
                }
            }
        }


        //Convert Winner to String
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < targetLength; i++) {
            if((winner & (1 << i)) != 0) { //Need to include character at i in the final result
                if(count != 0) {
                    sb.append(count);
                    count = 0;
                }
                sb.append(target.charAt(i));
            }
            else count++;
        }

        if(count != 0) sb.append(count);

        return sb.toString();
    }
}