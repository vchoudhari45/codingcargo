package com.vc.hard;

class L920 {
    public int numMusicPlaylists(int N, int L, int K) {
        //N > K return 0 because every song has to be played at least once
        if(N == 0 || L == 0 || N > L) return 0;

        long[][] dp = new long[N + 1][L + 1];
        /**
         F(N, L, K) = N * F(N - 1, L - 1, K) + (N - K) * F(N, L - 1, K)
         */
        dp[0][0] = 1;
        int MOD = (int)1e9 + 7;
        for(int songs = 1; songs <= N; songs++) {
            for(int slot = 1; slot <= L; slot++) {
                dp[songs][slot] = (songs * dp[songs - 1][slot - 1]) % MOD;
                if(songs - K > 0) dp[songs][slot] += ((songs - K) * dp[songs][slot - 1]) % MOD;
                dp[songs][slot] %= MOD;
            }
        }
        return (int)dp[N][L];
    }
}
