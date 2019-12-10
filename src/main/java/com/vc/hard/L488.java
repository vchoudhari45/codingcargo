package com.vc.hard;

import java.util.*;

class L488 {
    public int findMinStep(String board, String hand) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < hand.length(); i++) {
            map.put(hand.charAt(i), map.getOrDefault(hand.charAt(i), 0) + 1);
        }
        //System.out.println("Map: "+map);
        int res = solve(board, map);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(String board, HashMap<Character, Integer> map) {
        //System.out.println("Board: "+board+" map: "+map);

        if(board.length() == 0) return 0;
        else {
            int resMin = Integer.MAX_VALUE;
            for(int i = 0; i < board.length(); i++) {
                int j = i;
                while(j < board.length() && board.charAt(j) == board.charAt(i)) j++;
                int sameCount = j - i;
                int requiredCount = sameCount <= 3 ? 3 - sameCount: 0;
                char requiredColor = board.charAt(i);

                String newBoard = board.substring(0, i) +
                        (j < board.length() ? board.substring(j, board.length()): "");

                if(requiredCount == 0 ||
                        map.containsKey(requiredColor) && map.get(requiredColor) >= requiredCount ) {

                    if(requiredCount > 0) map.put(requiredColor, map.get(requiredColor) - requiredCount);

                    // System.out.println("Befor Old: "+board+
                    //                    " New: "+newBoard+
                    //                    " i: "+i+
                    //                    " j: "+j+
                    //                    " map: "+map+
                    //                    " requiredCount: "+requiredCount+
                    //                    " requiredColor: "+requiredColor);
                    int res = solve(newBoard, map);
                    if(res != Integer.MAX_VALUE) {
                        res = res + requiredCount;
                        resMin = Math.min(res, resMin);
                    }

                    // System.out.println("After Old: "+board+
                    //                    " New: "+newBoard+
                    //                    " i: "+i+
                    //                    " j: "+j+
                    //                    " map: "+map+
                    //                    " requiredCount: "+requiredCount+
                    //                    " requiredColor: "+requiredColor+
                    //                    " res: "+res);

                    if(requiredCount > 0) map.put(requiredColor, map.get(requiredColor) + requiredCount);
                }
            }
            return resMin;
        }
    }
}
