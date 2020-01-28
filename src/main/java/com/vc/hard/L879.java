package com.vc.hard;

import java.util.*;

class L879 {
    int MOD = (int)1e9 + 7;

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        /**
             State is defined by (currentMembers, currentProfit, index)
             combinations
         */
        int[][][] memo = new int[P + 1][G + 1][group.length + 1];
        for(int [][] arr : memo) for(int [] subArr : arr) Arrays.fill(subArr, -1);
        int currentMembers = 0, currentProfit = 0, index = 0, requiredProfit = P, allowedMembers = G;
        return solve(currentMembers, currentProfit, index, requiredProfit, allowedMembers, group, profit, memo);
    }

    private int solve(int currentMembers, int currentProfit, int index,
                      int requiredProfit, int allowedMembers, int[] group, int[] profit, int[][][] memo) {
        if(index == group.length) return 0;
        if(currentMembers > allowedMembers) return 0;
        if(memo[Math.min(currentProfit, requiredProfit)][currentMembers][index] != -1)
            return memo[Math.min(currentProfit, requiredProfit)][currentMembers][index];

        int res = 0;
        if(currentMembers + group[index] <= allowedMembers) {
            if(currentProfit + profit[index] >= requiredProfit) res++;
            res += solve(currentMembers + group[index], currentProfit + profit[index], index + 1,
                    requiredProfit, allowedMembers, group, profit, memo) % MOD;
        }
        res += solve(currentMembers, currentProfit, index + 1, requiredProfit, allowedMembers, group, profit, memo) % MOD;

        memo[Math.min(currentProfit, requiredProfit)][currentMembers][index] = res % MOD;
        return memo[Math.min(currentProfit, requiredProfit)][currentMembers][index];
    }
}
