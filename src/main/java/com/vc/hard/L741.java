package com.vc.hard;

class L741 {
    /*
        Idea here is to maintain the state of forward path & backward path at the same time
        because cherries picked up during the forward path will not be available on the backward path

        so let's maintain 4 dimensional array of state and max at that state
           dp[x1][y1][x2][y2]
        but since we can
           move only right & down on the forward path &
           move only left & up on the backward path
        we can reduce the time complexity to n3 because x1 + y1 = x2 + y2 and so state array will be
           dp[x1][y1][x2]

       Max value at dp[x1][y1][x2] will be max of previous state and previous states are as below
        dp[x1 - 1][y1][x2 - 1]  <- Forward path is coming from above & Backward Path is coming from below
        dp[x1 - 1][y1][x2]      <- Forward path is coming from above & Backward Path is coming from right
        dp[x1][y1 - 1][x2 - 1]  <- Forward path is coming from left & Backward Path is coming below
        dp[x1][y1 -1][x2]       <- Forward path is coming from left & Backward Path is coming right

        Add grid(x1)(y1) value to Max from above
        if (x1, y1) & (x2, y2) are different positions then add grid(x2, y2) as well

        build this and return dp(n)(m)(n)
   */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n + 1][m + 1][n + 1];

        for(int x1 = 0; x1 <= n; x1++) {
            for(int y1 = 0; y1 <= m; y1++) {
                for(int x2 = 0; x2 <= n; x2++) {
                    dp[x1][y1][x2] = Integer.MIN_VALUE;
                }
            }
        }

        dp[1][1][1] = grid[0][0];
        for(int x1 = 1; x1 <= n; x1++) {
            for(int y1 = 1; y1 <= m; y1++) {
                for(int x2 = 1; x2 <= n; x2++) {
                    int y2 = x1 + y1 - x2;
                    if(y2 > 0
                            && y2 <= m
                            && dp[x1][y1][x2] <= 0
                            && grid[x1 - 1][y1 - 1] != -1
                            && grid[x2 - 1][y2 - 1] != -1) {

                        int max = Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]);
                        max = Math.max(max, dp[x1][y1 - 1][x2]);
                        max = Math.max(max, dp[x1][y1 - 1][x2 - 1]);

                        if(max >= 0) {
                            max += grid[x1 - 1][y1 - 1];
                            if(x1 != x2 && y1 != y2) max += grid[x2 - 1][y2 - 1];
                            dp[x1][y1][x2] = max;
                        }
                    }
                }
            }
        }

        // for(int x1 = 0; x1 <= n; x1++) {
        //     for(int y1 = 0; y1 <= m; y1++) {
        //         for(int x2 = 0; x2 <= n; x2++) {
        //             System.out.print(dp[x1][y1][x2]+" ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        return dp[n][m][n] == Integer.MIN_VALUE ? 0 : dp[n][m][n];
    }
}
