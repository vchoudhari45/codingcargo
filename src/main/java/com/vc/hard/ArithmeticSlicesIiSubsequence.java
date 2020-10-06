package com.vc.hard;

import java.util.HashMap;

class ArithmeticSlicesIiSubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;

        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        dp[0] = new HashMap<Integer, Integer>();

        int res = 0;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];

                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;

                int diffInt = (int)diff;

                int ci = dp[i].getOrDefault(diffInt, 0);
                int cj = dp[j].getOrDefault(diffInt, 0);

                res += cj;
                dp[i].put(diffInt, ci + cj + 1);
            }
        }
        return res;
    }
}
