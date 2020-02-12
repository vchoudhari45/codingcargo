package com.vc.hard;

import java.util.*;

class L1259 {
    //https://www.youtube.com/watch?v=YGsmvcQzpxs
    HashMap<Integer, Integer> cache = new HashMap<>();
    int MOD = (int)1e9 + 7;
    public int numberOfWays(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if(n == 0) return 1;
        long total = 0;
        for(int mid = 0; mid < n; mid += 2) {
            long left = numberOfWays(mid) % MOD;
            long right = numberOfWays(n - mid - 2) % MOD;
            total += (left * right) % MOD;
        }
        total = total % MOD;
        cache.put(n, (int)total);
        return (int)total;
    }
}