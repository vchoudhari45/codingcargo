package com.vc.medium;

class L1031 {

    private int[] prefix;
    private int n = 0;

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if(A == null || A.length == 0) return 0;
        this.n = A.length;
        this.prefix = new int[n + 1];

        for(int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + A[i - 1];

        return Math.max(helper(L, M), helper(M, L));
    }

    private int helper(int L, int M) {
        int lMax = 0, mSum = 0, max = 0;
        for(int i = L; i + M <= n; i++) {
            lMax = Math.max(lMax, getSum(i - L, i));
            mSum = getSum(i, i + M);
            max = Math.max(max, lMax + mSum);
        }
        return max;
    }

    private int getSum(int from, int to) {
        return prefix[to] - prefix[from];
    }
}