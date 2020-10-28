package com.vc.hard;

import java.util.*;

class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1 == null || s2 == null || n1 <= 0 && n2 <= 0) {
            return 0;
        }

        //Key: Position of S2
        //Value: Number of times S1 is used
        HashMap<Integer, Integer> loopMap = new HashMap<>();

        //Key: Number of times S1 is used
        //Value: Number of times S2 appears
        HashMap<Integer, Integer> repMap = new HashMap<>();

        int s2Count = 0, s1Count = 1, s2Index = 0;
        while (s1Count <= n1) {
            for(int s1Index = 0; s1Index < s1.length(); s1Index++) {
                if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
                    s2Index++;
                    if(s2Index == s2.length()) {
                        s2Count++;
                        s2Index = 0;
                    }
                }
            }
            repMap.put(s1Count, s2Count);
            if(loopMap.containsKey(s2Index)) {
                break;
            }
            loopMap.put(s2Index, s1Count);
            s1Count++;
        }

        if(s1Count >= n1) return s2Count / n2;

        int s1CountStartOfLoop = loopMap.get(s2Index);
        int s1CountInLoop = s1Count - s1CountStartOfLoop;
        int s2CountInLoop = repMap.get(s1Count) - repMap.get(s1CountStartOfLoop);

        //S2 Count Within a loop
        int repeatCount = (n1 - s1CountStartOfLoop) / s1CountInLoop; //How many loops of s1 are possible with n1 as higher limit
        int res = repeatCount * s2CountInLoop;

        //S2 Count Outside of a loop
        res += repMap.get(s1CountStartOfLoop + (n1 - s1CountStartOfLoop) % s1CountInLoop);
        return res / n2;
    }
}