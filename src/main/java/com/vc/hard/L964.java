package com.vc.hard;

import java.util.HashMap;

class L964 {
    public int leastOpsExpressTarget(int x, int target) {
        return solve(x, target, new HashMap<Integer, Integer>());
    }

    private int solve(int x, int target, HashMap<Integer, Integer> memo) {
        if(x == target) return 0;
        else if(target == 1) return 1;
        else if(memo.containsKey(target)) return memo.get(target);

        //Do product *= x greedily to reach as much close as possible to target
        int count = 0;
        long product = x;
        while(product < target) {
            product *= x;
            count++;
        }

        if(product == target) return count;

        //Try subtracting 1 from product (x/x)
        int sub = 0;
        int nextTarget = (int)(product - target);
        if(nextTarget < target) sub = count + solve(x, nextTarget, memo) + 1;
        else sub = Integer.MAX_VALUE;

        //Go one step back(product /= x) and Try adding 1 to product (x/x)
        product /= x;
        nextTarget = (int)(target - product);
        int add = solve(x, nextTarget, memo) + (count == 0 ? 2 : count);

        int ans = Math.min(add, sub);

        memo.put(target, ans);
        return ans;
    }
}