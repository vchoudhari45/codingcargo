package com.vc.hard;

import java.util.Arrays;

class L1000 {
    private int K = 0;
    private int[] prefixSum;
    private int[][][] memo;
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;

        this.prefixSum = new int[n + 1];
        this.K = K;
        this.memo = new int[n + 1][n + 1][K + 1];

        for(int i = 0; i < memo.length; i++) {
            for(int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        for(int i = 0; i < stones.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }
        int res = solve(1, stones.length, 1, stones);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int left, int right, int targetPiles, int[] stones) {
        if(memo[left][right][targetPiles] != -1) return memo[left][right][targetPiles];
        if(right - left + 1 < targetPiles) return Integer.MAX_VALUE;
        if(left == right) {
            if(targetPiles == 1) return 0;
            else return Integer.MAX_VALUE;
        }
        if(targetPiles == 1) {
            int res = solve(left, right, K, stones);
            if(res == Integer.MAX_VALUE) {
                memo[left][right][targetPiles] = res;
                return res;
            }
            else {
                memo[left][right][targetPiles] = res + prefixSum[right] - prefixSum[left - 1];
                return memo[left][right][targetPiles];
            }
        }
        else {
            int min = Integer.MAX_VALUE;
            for(int i = left; i < right; i++) {
                int l = solve(left, i, targetPiles - 1, stones);
                int r = solve(i + 1, right, 1, stones);
                if(l == Integer.MAX_VALUE || r == Integer.MAX_VALUE) continue;
                min = Math.min(min, l + r);
            }
            memo[left][right][targetPiles] = min;
            return min;
        }
    }
}
