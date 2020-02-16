package com.vc.medium;

import java.util.HashMap;
import java.util.Map;

class L279 {
    private Map<Integer, Integer> memo;

    public int numSquares(int n) {
        memo = new HashMap<>();
        return numSquaresFrom(n);
    }

    private int numSquaresFrom(int target) {
        if (target == 0 || target == 1) {
            return target;
        }

        if (memo.containsKey(target)) return memo.get(target);

        int minSquares = Integer.MAX_VALUE;
        for(int base = 1; base <= target / 2; base++) {
            if (base * base <= target) {
                minSquares = Math.min(minSquares, numSquaresFrom(target - base * base) + 1);
            }
        }

        memo.put(target, minSquares);
        return minSquares;
    }
}
