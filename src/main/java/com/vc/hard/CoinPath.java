package com.vc.hard;

import java.util.*;

class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        if(A == null || A.length == 0 || A[A.length - 1] == -1) return new ArrayList<>();

        int n = A.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int[] lexi = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = A[0];
        for(int i = 1; i < n; i++) {
            if(A[i] == -1) continue;
            for(int j = Math.max(0, i - B); j < i; j++) {
                if(dp[j] != Integer.MAX_VALUE &&
                        (dp[j] + A[i] < dp[i] || dp[j] + A[i] == dp[i] && lexi[i] < lexi[j] + 1)) {
                    dp[i] = dp[j] + A[i];
                    prev[i] = j;
                    lexi[i] = lexi[j] + 1;
                }
            }
        }

        List<Integer> list = new LinkedList<>();
        for(int i = n - 1; i >= 0; i = prev[i]) {
            list.add(0, i + 1);
        }
        if(list.get(0) != 1) list.clear();
        return list;
    }
}