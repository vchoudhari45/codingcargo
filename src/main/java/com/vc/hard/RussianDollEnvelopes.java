package com.vc.hard;

import java.util.*;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int cmp = Integer.compare(x[0], y[0]);
                if(cmp == 0) return Integer.compare(y[1], x[1]);
                else return cmp;
            }
        });

        int[] secondDimension = new int[n];
        for(int i = 0; i < n; i++) secondDimension[i] = envelopes[i][1];
        return LISBinarySearch(secondDimension);
    }

    private int LISDynamicProgramming(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int max = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max + 1;
    }

    private int LISBinarySearch(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int len = 0;
        for(int num: arr) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if(index == len) len++;
        }
        return len;
    }
}