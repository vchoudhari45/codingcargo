package com.vc.hard;

class L629 {
    int MOD = (int)1e9 + 7;
    public int kInversePairs(int n, int k) {
        Integer[][] memo = new Integer[n + 1][k + 1];
        return solve(n, k, memo);
    }

    private int solve(int n, int k, Integer[][] memo) {
        if(n == 0) return 0;
        if(k == 0) return 1;
        if(memo[n][k] != null) return memo[n][k];

        int inv = 0;
        for(int i = 0; i <= Math.min(k, n - 1); i++) {
            inv = (inv + solve(n - 1, k - i, memo)) % MOD;
        }
        memo[n][k] = inv;
        return inv;
    }
}
