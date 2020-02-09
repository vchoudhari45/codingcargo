package com.vc.hard;

import java.util.*;

class L940 {
    public int distinctSubseqII(String S) {
        // int res = 0, MOD = (int)1e9 + 7, n = S.length();
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < i; j++) {
        //         if(S.charAt(i) != S.charAt(j)) {
        //             dp[i] += dp[j];
        //             dp[i] %= MOD;
        //         }
        //     }
        //     res += dp[i];
        //     res %= MOD;
        // }
        // return res;

        HashMap<Character, Integer> map = new HashMap<>();
        int existingTotal = 0, MOD = (int)1e9 + 7, n = S.length();
        for(int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            int appendingCurrentChCount = (existingTotal + 1 - map.getOrDefault(ch, 0)) % MOD;
            existingTotal = (existingTotal + appendingCurrentChCount) % MOD;
            map.put(ch, (map.getOrDefault(ch, 0) + appendingCurrentChCount) % MOD);
        }
        return (existingTotal + MOD) % MOD;
    }
}
