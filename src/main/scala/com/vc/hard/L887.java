package com.vc.hard;

class L887 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for(int eggs = 1; eggs <= K; eggs++) {
            for(int floors = 1; floors <= N; floors++) {
                if(eggs == 1) dp[eggs][floors] = floors;
                else {
                    dp[eggs][floors] = Integer.MAX_VALUE;
                    int lo = 1;
                    int hi = floors;
                    int result = floors;
                    while(lo < hi) {
                        int assumeAnswer = lo + (hi - lo) / 2;
                        int eggDoesBreakCondition = dp[eggs][assumeAnswer - 1];
                        int eggBreakCondition = dp[eggs - 1][floors - assumeAnswer];
                        result = Math.min(result, 1 + Math.max(eggDoesBreakCondition, eggBreakCondition));
                        if(eggDoesBreakCondition < eggBreakCondition) lo = assumeAnswer + 1;
                        else hi = assumeAnswer;
                    }
                    dp[eggs][floors] = result;
                }
            }
        }
        return dp[K][N];
    }
}
