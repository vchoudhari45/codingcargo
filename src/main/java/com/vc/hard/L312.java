package com.vc.hard;

class L312 {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int l = 0; l < n; l++) {
            for(int from = 0; from + l < n; from++) {
                int to = from + l;

                int leftValue = from - 1 >= 0 ? nums[from - 1] : 1;
                int rightValue = to + 1 < nums.length ? nums[to + 1] : 1;

                if(l == 0) {
                    dp[from][to] = nums[from] * rightValue * leftValue;
                }
                else {
                    for(int burstLast = from; burstLast <= to; burstLast++) {
                        int before = burstLast - 1 >= 0 ? dp[from][burstLast - 1] : 0;
                        int after  = burstLast + 1 < n ? dp[burstLast + 1][to] : 0;
                        dp[from][to] = Math.max(dp[from][to],
                                before + after + nums[burstLast] * rightValue * leftValue);
                    }
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) System.out.format("%5s", dp[i][j]+" ");
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}