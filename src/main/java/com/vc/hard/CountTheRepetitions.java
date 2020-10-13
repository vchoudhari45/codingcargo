package com.vc.hard;

import java.util.*;

class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s2 == null || n1 <= 0 || n2 <= 0) {
            return 0;
        }

        // key: the rest position of s2  value:the number of s1
        HashMap<Integer, Integer> posMap = new HashMap<>();

        // repTimes[i]: number of used s1 is i, repetitions times is repTimes[i]
        int[] repTimes = new int[102];

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int s1Num = 1;
        int posInS2 = 0;
        int times = 0;
        while (s1Num <= n1) {
            for (int j = 0; j < len1; j++) {
                if (chars1[j] == chars2[posInS2]) {
                    posInS2++;
                    if (posInS2 == len2) {
                        times++;
                        posInS2 = 0;
                    }
                }
            }
            repTimes[s1Num] = times;
            if (posMap.containsKey(posInS2)) {
                break;
            }
            posMap.put(posInS2, s1Num);
            s1Num++;
        }
        if (s1Num == n1) return times / n2;

        int s1UsedFor = posMap.get(posInS2);
        int s1NumInLoop = s1Num - s1UsedFor;                       // s1 num in each loop
        int s2NumInLoop = repTimes[s1Num] - repTimes[s1UsedFor];  // s2 num in each loop
        int repeatCount = (n1 - s1UsedFor) / s1NumInLoop;
        int n = repeatCount * s2NumInLoop;
        n += repTimes[s1UsedFor + (n1 - s1UsedFor) % s1NumInLoop];
        return n / n2;
    }
}