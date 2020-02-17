package com.vc.medium;

import java.util.*;

class L96 {
    public int numTrees(int n) {
        return solve(n, new HashMap<Integer, Integer>());
    }

    private int solve(int n, HashMap<Integer, Integer> map) {
        if(map.containsKey(n)) return map.get(n);

        if(n == 0) return 1;

        int res = 0;
        for(int i = 1; i <= n; i++) {
            res += solve(i - 1, map) * solve(n - i, map);
        }
        map.put(n, res);
        return res;
    }
}
