package com.vc.medium;

import java.util.*;

class L873 {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) index.put(A[i], i);

        int[][] dp = new int[N][N];
        int ans = 0;

        for (int k = 1; k < N; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cand = dp[i][j] > 2 ? dp[i][j] + 1 : 3;
                    dp[j][k] = cand;
                    ans = Math.max(ans, cand);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}

