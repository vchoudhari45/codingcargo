package com.vc.medium;

class L1043 {
    Integer[] memo;
    int[] A;
    int K, n;

    public int maxSumAfterPartitioning(int[] A, int K) {
        this.n = A.length;
        this.K = K;
        this.memo = new Integer[n + 1];
        this.A = A;

        return helper(0);
    }

    private int helper(int startIndex) {
        if(startIndex >= n) return 0;

        if(memo[startIndex] != null) return memo[startIndex];

        int max = 0, maxValue = 0, count = 0;
        for(int i = startIndex; i < Math.min(n, startIndex + K); i++) {
            maxValue = Math.max(maxValue, A[i]);
            count++;

            int localMax = maxValue * count + helper(i + 1);
            max = Math.max(max, localMax);
        }

        memo[startIndex] = max;

        return max;
    }
}
