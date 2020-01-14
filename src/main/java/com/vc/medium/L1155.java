package com.vc.medium;

import java.util.*;

class L1155 {
    int MOD = (int) 1e9 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        return solve(d, target, f, new HashMap<String, Integer>());
    }

    private int solve(int d, int target, int f, HashMap<String, Integer> memo) {
        if(d == 0 && target == 0) return 1;
        if(d == 0 || target == 0) return 0;
        String key = d+" "+target;
        if(memo.containsKey(key)) return memo.get(key);
        int res = 0;
        for(int i = 1; i <= f; i++) {
            if(target >= i) res = (res + solve(d - 1, target - i, f, memo)) % MOD;
            else break;
        }
        memo.put(key, res % MOD);
        return res % MOD;
    }
}
