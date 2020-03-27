package com.vc.medium;

import java.util.*;

class L96 {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    public int numTrees(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if(memo.containsKey(n)) return memo.get(n);

        if(n == 0) return 1; //root element will be counted

        int res = 0;
        for(int i = 1; i <=n; i++) {
            int left = helper(i - 1);
            int right = helper(n - i);
            res += left * right;
        }
        return res;
    }
}