package com.vc.hard;

import java.util.*;

class ZumaGame {
    public int findMinStep(String board, String hand) {
        HashMap<Character, Integer> handMap = new HashMap<>();
        for(int i = 0; i < hand.length(); i++) {
            char ch = hand.charAt(i);
            handMap.put(ch, handMap.getOrDefault(ch, 0) + 1);
        }
        int res = helper(board, handMap);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(String board, HashMap<Character, Integer> handMap) {
        if(board.length() == 0) return 0;
        else {
            int resMin = Integer.MAX_VALUE;
            for(int i = 0; i < board.length(); i++) {
                char ch = board.charAt(i);
                int j = i;
                while(j < board.length() && ch == board.charAt(j)) j++;
                int matchingCount = j - i;
                int requiredCount = Math.max(0, 3 - matchingCount);
                if(requiredCount == 0 || (handMap.containsKey(ch) && handMap.getOrDefault(ch, 0) >= requiredCount)) {

                    if(requiredCount > 0) handMap.put(ch, handMap.get(ch) - requiredCount);

                    String newBoard = board.substring(0, i) + board.substring(j);
                    int res = helper(newBoard, handMap);
                    if(res != Integer.MAX_VALUE) resMin = Math.min(resMin, requiredCount + res);

                    if(requiredCount >0) handMap.put(ch, handMap.getOrDefault(ch, 0) + requiredCount);
                }
            }
            return resMin;
        }
    }
}