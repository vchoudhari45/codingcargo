package com.vc.medium;

import java.util.Arrays;

class L801 {
    int[][] dp;
    public int minSwap(int[] A, int[] B) {
        dp = new int[A.length][2];
        for (int[] row: dp) Arrays.fill(row, -1);
        return minSwapHelper(A, B, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
    }

    private int minSwapHelper(int[] A, int[] B, int i, int prevA, int prevB, int swapped) {
        if(i == A.length) return 0;
        if(dp[i][swapped] != -1) return dp[i][swapped];
        int minSwaps = Integer.MAX_VALUE;
        if(A[i] > prevA && B[i] > prevB) {
            minSwaps = minSwapHelper(A, B, i + 1, A[i], B[i], 0);
        }
        swap(A, B, i);
        if(A[i] > prevA && B[i] > prevB) { //Make sure swapping won't cause any issue
            minSwaps = Math.min(minSwaps, minSwapHelper(A, B, i + 1, A[i], B[i], 1) + 1);
        }
        swap(A, B, i);
        dp[i][swapped] = minSwaps;
        return minSwaps;
    }

    private void swap(int[] A, int[] B, int i) {
        int t = A[i];
        A[i] = B[i];
        B[i] = t;
    }
}
