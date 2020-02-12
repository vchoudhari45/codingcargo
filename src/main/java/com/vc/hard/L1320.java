package com.vc.hard;

import java.util.*;

class L1320 {
    private int[][][] memo;

    public int minimumDistance(String word) {
        if(word.length() == 0) return 0;

        this.memo = new int[27][27][word.length() + 1];

        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++) Arrays.fill(memo[i][j], -1);

        //left hand start at char 0, right hand can start any location
        int min = Integer.MAX_VALUE;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            int value = solve(1, word, location(word.charAt(0)), location(ch));
            min = Math.min(min, value);
        }
        return min;
    }

    private int solve(int index, String word, int[] left, int[] right) {
        if(index == word.length()) return 0;

        int lPos = 6 * left[0] + left[1];
        int rPos = 6 * right[0] + right[1];
        if(memo[lPos][rPos][index] != -1) return memo[lPos][rPos][index];

        char ch = word.charAt(index);
        int[] location = location(ch);

        //UseLeft finger
        int costLeft = distance(left, location);
        int useLeft = costLeft + solve(index + 1, word, location, right);

        //UseRight finger
        int costRight = distance(right, location);
        int useRight = costRight + solve(index + 1, word, left, location);

        int res = Math.min(useLeft, useRight);
        memo[lPos][rPos][index] = res;

        return memo[lPos][rPos][index];
    }

    private int distance(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    private int[] location(char ch) {
        int x = (ch - 'A') / 6;
        int y = (ch - 'A') % 6;
        //System.out.println(ch+" "+x+" "+y);
        return new int[]{x, y};
    }
}