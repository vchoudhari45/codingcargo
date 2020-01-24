package com.vc.medium;

class L790 {
    public int numTilings(int N) {
        long dp_1 = 1;
        long dp_2 = 2;
        long dp_3 = 5;
        long dp_4 = 0;

        int MOD = (int)1e9 + 7;

        if(N == 1) return (int)dp_1;
        if(N == 2) return (int)dp_2;
        if(N == 3) return (int)dp_3;

        for(int i = 4; i <= N; i++) {
            dp_4 = (2 * dp_3 + dp_1) % MOD;
            dp_1 = dp_2 % MOD;
            dp_2 = dp_3 % MOD;
            dp_3 = dp_4 % MOD;
        }
        return (int)dp_4;
    }
}
