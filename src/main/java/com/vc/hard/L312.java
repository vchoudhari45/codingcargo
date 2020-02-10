package com.vc.hard;

import java.util.Arrays;

class L312 {
    int[][] memo;
    public int maxCoins(int[] arr) {
        int n = arr.length;
        this.memo = new int[n + 2][n + 2];
        int[] newArr = new int[n + 2];

        for(int i = 0; i < n; i++) newArr[i + 1] = arr[i];
        newArr[0] = newArr[newArr.length - 1] = 1;

        for(int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(0, newArr.length - 1, newArr);
    }

    private int solve(int left, int right, int[] arr) {
        if(left + 1 == right) return 0;
        if(memo[left][right] != -1) return memo[left][right];
        else {
            int max = 0;
            for(int i = left + 1; i < right; i++) {
                int res = arr[left] * arr[i] * arr[right] +
                        solve(left, i, arr) + solve(i, right, arr);
                max = Math.max(max, res);
            }
            memo[left][right] = max;
            return max;
        }
    }
}