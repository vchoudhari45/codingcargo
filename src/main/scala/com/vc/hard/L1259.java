package com.vc.hard;

import java.util.*;

class L1259 {
    //https://www.youtube.com/watch?v=YGsmvcQzpxs
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int MOD = (int)1e9 + 7;
    public int numberOfWays(int n) {
        if(map.containsKey(n)) return map.get(n);

        if(n % 2 != 0) return 0;
        if(n == 0) return 1;

        int sum = 0;
        for(int i = 0; i < n; i+=2) {
            sum += ((long)numberOfWays(i) * numberOfWays(n - 2 - i)) % MOD;
            sum %= MOD;
        }
        map.put(n, sum);
        return sum;
    }
}
