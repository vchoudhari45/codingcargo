package com.vc.hard;

import java.util.*;

class L354 {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            int cmp = a[0] - b[0];
            if(cmp == 0) return a[1] - b[1];
            else return cmp;
        });

        // for(int i = 0 ; i < arr.length; i++) {
        //     System.out.println(arr[i][0]+" "+arr[i][1]);
        // }

        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(canInsert(j, i, arr)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < dp.length; i++) max = Math.max(max, dp[i]);
        return max;
    }

    private boolean canInsert(int small, int big, int[][] arr) {
        return arr[small][0] < arr[big][0] && arr[small][1] < arr[big][1];
    }
}
