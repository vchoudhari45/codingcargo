package com.vc.hard;

class L403 {
    public boolean canCross(int[] stones) {
        //0,1,3,5,6,8,12,17
        int n = stones.length;
        //dp[i][j] denotes if frog can make a jump of size j from stone at index i
        boolean dp[][] = new boolean[n][n + 1];
        dp[0][1] = true;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff > n || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 < n) dp[i][diff + 1] = true;
                if(i == n - 1) return true;
            }
        }
        return false;
    }
}
