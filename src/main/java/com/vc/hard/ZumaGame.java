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
        else if(handMap.size() == 0) return Integer.MAX_VALUE;
        else {
            int resMin = Integer.MAX_VALUE;
            for(int index = 0; index < board.length(); index++) {
                int to = index;
                char requiredChar = board.charAt(to);
                while(to < board.length() && board.charAt(to) == requiredChar) to++;
                int length = to - index;
                int requiredLength = Math.max(3 - length, 0);
                if(requiredLength == 0 || handMap.getOrDefault(requiredChar, 0) >= requiredLength) {
                    String newBoard = board.substring(0, index) + board.substring(to);
                    handMap.put(requiredChar, handMap.getOrDefault(requiredChar, 0) - requiredLength);
                    int resInternal = helper(newBoard, handMap);
                    if(resInternal != Integer.MAX_VALUE) {
                        resMin = Math.min(resMin, resInternal + requiredLength);
                    }
                    handMap.put(requiredChar, handMap.getOrDefault(requiredChar, 0) + requiredLength);
                }
            }
            return resMin;
        }
    }
}