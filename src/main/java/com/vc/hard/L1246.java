package com.vc.hard;

import java.util.Arrays;

class L1246 {
    int[][] memo;

    public int minimumMoves(int[] arr) {
        this.memo = new int[arr.length + 1][arr.length + 1];
        for(int i = 0; i < arr.length; i++) Arrays.fill(memo[i], -1);

        return solve(arr, 0, arr.length - 1);
    }

    private int solve(int[] arr, int left, int right) {
        if(left >= right) return 1;

        if(memo[left][right] != -1) return memo[left][right];

        if(arr[left] == arr[right]) return solve(arr, left + 1, right - 1);

        int min = Integer.MAX_VALUE;
        for(int mid = left; mid < right; mid++) {
            int l = solve(arr, left, mid);
            int r = solve(arr, mid + 1, right);
            min = Math.min(l + r,  min);
        }

        memo[left][right] = min;
        return min;
    }
}