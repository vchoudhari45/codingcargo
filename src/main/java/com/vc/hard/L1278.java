package com.vc.hard;

import java.util.Arrays;

class L1278 {
    private int[][][] memo;
    public int palindromePartition(String s, int k) {
        this.memo = new int[s.length() + 1][s.length() + 1][k + 1];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return solve(s, 0, s.length() - 1, k);
    }

    private int solve(String s, int left, int right, int k) {
        if(right - left + 1 < k) return Integer.MAX_VALUE;

        if(right - left + 1 == k) return 0;

        if(memo[left][right][k] != -1)  return memo[left][right][k];

        if(k == 1) {
            int changeRequired = changeRequired(s, left, right);
            memo[left][right][k] = changeRequired;
            return memo[left][right][k];
        }

        int res = Integer.MAX_VALUE;
        for(int mid = left; mid < right; mid++) {
            int l = solve(s, left, mid, 1);
            int r = solve(s, mid + 1, right, k - 1);
            if(l == Integer.MAX_VALUE || r == Integer.MAX_VALUE) continue;
            res = Math.min(res, l + r);
        }

        memo[left][right][k] = res;
        return memo[left][right][k];
    }

    private int changeRequired(String s, int left, int right) {
        int res = 0;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) res++;
            left++;
            right--;
        }
        return res;
    }
}