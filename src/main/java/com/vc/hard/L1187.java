package com.vc.hard;

import java.util.*;

class L1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> arr2Sorted = new TreeSet<Integer>();
        for(int i = 0; i < arr2.length; i++) {
            arr2Sorted.add(arr2[i]);
        }

        int n = arr1.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = Integer.MIN_VALUE;

        for(int j = 1; j < dp.length; j++) {
            for(int i = 0; i <= j; i++) {
                if(arr1[j - 1] > dp[i][j - 1]) {
                    dp[i][j] = arr1[j - 1];
                }

                if(i > 0 && arr2Sorted.higher(dp[i - 1][j - 1]) != null) {
                    dp[i][j] = Math.min(dp[i][j], arr2Sorted.higher(dp[i - 1][j - 1]));
                }

                if(j == dp.length - 1 && dp[i][j] != Integer.MAX_VALUE) return i;
            }
        }
        return -1;
    }
}
