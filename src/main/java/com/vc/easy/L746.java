package com.vc.easy;

class L746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <= 1) return 0;

        int n = cost.length;
        for(int i = 2; i < n; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
