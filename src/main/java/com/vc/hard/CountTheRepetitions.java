package com.vc.hard;

import java.util.*;

class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1 == null || s2 == null || n1 <= 0 && n2 <= 0) {
            return 0;
        }

        // key: position of s2  value:the number of s1
        HashMap<Integer, Integer> loopMap = new HashMap<>();

        //key: number of used s1 is i value:repetitions times
        HashMap<Integer, Integer> repMap = new HashMap<>();

        int count = 0, s1Num = 1, s2Index = 0;
        while (s1Num <= n1) {
            for(int s1Index = 0; s1Index < s1.length(); s1Index++) {
                if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
                    s2Index++;
                    if(s2Index == s2.length()) {
                        count++;
                        s2Index = 0;
                    }
                }
            }
            repMap.put(s1Num, count);
            if(loopMap.containsKey(s2Index)) {
                break;
            }
            loopMap.put(s2Index, s1Num);
            s1Num++;
        }

        if(s1Num >= n1) return count / n2;

        int s1NumStartOfLoop = loopMap.get(s2Index);
        int s1NumInLoop = s1Num - s1NumStartOfLoop;
        int s2NumInLoop = repMap.get(s1Num) - repMap.get(s1NumStartOfLoop);
        int repeatCount = (n1 - s1NumStartOfLoop) / s1NumInLoop;
        int res = repeatCount * s2NumInLoop;
        res += repMap.get(s1NumStartOfLoop + (n1 - s1NumStartOfLoop) % s1NumInLoop);
        return res / n2;
    }
}