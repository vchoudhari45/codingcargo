package com.vc.hard;

class L920 {
    int MOD = (int)1e9 + 7;

    public int numMusicPlaylists(int N, int L, int K) {
        Long[][] memo = new Long[N + 1][L + 1];
        return (int)solve(N, L, K, memo);
    }

    private long solve(int total, int playlist, int repeatAfter, Long[][] memo) {
        if(playlist == 0 && total != 0) return 0;
        if(playlist != 0 && total == 0) return 0;
        if(playlist == 0 && total == 0) return 1;
        if(memo[total][playlist] != null) return memo[total][playlist];

        long withoutRepeat = total * solve(total - 1, playlist - 1, repeatAfter, memo) % MOD;
        long withRepeat = Math.max(0, total - repeatAfter) * solve(total, playlist - 1, repeatAfter, memo) % MOD;

        long res = (withoutRepeat % MOD + withRepeat % MOD) % MOD;
        memo[total][playlist] = res;
        return res;
    }
}