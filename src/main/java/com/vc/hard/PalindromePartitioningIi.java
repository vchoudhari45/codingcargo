package com.vc.hard;

import java.util.Arrays;

class PalindromePartitioningIi {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            search(s, i, i, dp);              //odd length
            search(s, i, i + 1, dp);    //even length
        }
        return dp[n - 1];
    }

    private void search(String s, int left, int right, int[] dp) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(left == 0) {
                // left == 0, substring(0, right+1) is palindrome, no cut needed
                dp[right] = 0;
            }
            else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}