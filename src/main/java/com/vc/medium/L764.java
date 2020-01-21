package com.vc.medium;

class L764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = 1;
            }
        }

        for(int[] mine: mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(dp[i][j] == 0) continue;
                int dir = 1;
                while(j - dir >= 0 && j + dir < N &&
                        i - dir >= 0 && i + dir < N &&
                        dp[i][j - dir] == 1 && dp[i][j + dir] == 1 &&
                        dp[i - dir][j] == 1 && dp[i + dir][j] == 1) {
                    dir++;
                }
                max = Math.max(dir, max);
            }
        }
        return max;
    }
}
