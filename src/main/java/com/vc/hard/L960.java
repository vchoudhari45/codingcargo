package com.vc.hard;

import java.util.Arrays;

class L960 {
    public int minDeletionSize(String[] arr) {
        //MaxIncreasing Subsequence
        int n = arr.length;
        if(n == 0) return 0;

        int m = arr[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = m - 1;
        for(int i = 1; i < m; i++) {//Check max increasing subsequence at i for all the rows
            for(int j = 0; j < i; j++) {
                if(check(arr, i, j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //Remove max increasing subsequence from total length
            res = Math.min(res, m - dp[i]);
        }
        return res;
    }

    private boolean check(String[] arr, int i, int j) {
        for(String str: arr) {
            if(str.charAt(i) < str.charAt(j)) return false;
        }
        return true;
    }
}
