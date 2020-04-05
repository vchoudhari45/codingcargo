package com.vc.easy;

class L70 {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;

        int oneStepBefore = 1;
        int twoStepBefore = 1;
        int res = 0;
        for(int i = 2; i <= n; i++) {
            res = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = res;
        }
        return res;
    }
}
