package com.vc.hard;

import java.util.*;

class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;

        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int cmp = Integer.compare(x[0], y[0]);
                if(cmp == 0) return Integer.compare(x[1], y[1]);
                return cmp;
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(canInsert(envelopes[j], envelopes[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private boolean canInsert(int[] x, int[] y) {
        return x[0] < y[0] && x[1] < y[1];
    }
}