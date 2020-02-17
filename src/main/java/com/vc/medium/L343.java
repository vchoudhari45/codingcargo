package com.vc.medium;

import java.util.*;

class L343 {
    Map<Integer, Integer> memo = new HashMap<>();
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            //Either futher divide the number else use the number itself
            int subProblem = i * Math.max(n - i, integerBreak(n - i));
            res = Math.max(subProblem, res);
        }
        memo.put(n, res);
        return res;
    }
}