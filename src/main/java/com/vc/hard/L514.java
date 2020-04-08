package com.vc.hard;

import java.util.Arrays;

class L514 {

    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        this.memo = new int[ring.length() + 1][key.length() + 1];
        for(int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(ring, key, 0, 0);
    }

    private int helper(String ring, String key, int ringIndex, int keyIndex) {
        if(keyIndex == key.length()) return 0;

        if(memo[ringIndex][keyIndex] != -1) return memo[ringIndex][keyIndex];

        char ch = key.charAt(keyIndex);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++) {
            if(ring.charAt(i) != ch) continue;

            int distance = Math.abs(ringIndex - i);
            int minDistance = 1 + Math.min(distance, ring.length() - distance);

            min = Math.min(min, minDistance + helper(ring, key, i, keyIndex + 1));
        }

        memo[ringIndex][keyIndex] = min;
        return min;
    }
}