package com.vc.hard;

class L1335 {
    public int minDifficulty(int[] jobs, int d) {
        int[][] dp = new int[jobs.length + 1][d + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
        }
        int res = solve(jobs, 0, d, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int[] jobs, int finished, int d, int[][] dp) {
        if(dp[finished][d] != -1) return dp[finished][d];
        if(d == 0) {
            if(finished == jobs.length) return 0;
            else return Integer.MAX_VALUE;
        }
        else if(finished == jobs.length) return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;
        int difficulty = 0;
        for(int i = finished; i < jobs.length; i++) {
            difficulty = Math.max(difficulty, jobs[i]);
            int ans = solve(jobs, i + 1, d - 1, dp);
            if(ans != Integer.MAX_VALUE) res = Math.min(res, ans + difficulty);
        }
        dp[finished][d] = res;
        return res;
    }
}
