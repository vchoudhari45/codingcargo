package com.vc.hard;

import java.util.*;

class L956 {
    public int tallestBillboard(int[] rods) {
        /**
         i         = Considering i rods in the calculation
         j         = Difference between smaller & larger side
         dp[i][j]     = Length of larger side consider i rods
         dp[i][j] - j = Length of smaller side consider i rods

         [1, 2, 3]
         At dp[0][0] = 0
         Meaning considering 0 rods, difference between smaller & larger side is 0
         */
        int sum = 0;
        int len = rods.length;
        for(int r: rods) {
            sum += r;
        }

        int dp[][] = new int[len + 1][sum + 1];
        for(int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        for(int i = 1; i <= len; i++) {
            int rod = rods[i - 1];
            for(int j = 0; j <= sum - rod; j++) {
                if(dp[i - 1][j] >= 0) {
                    //case 1: Rod not used
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                    //case 2: Rod used for taller side
                    dp[i][j + rod] = Math.max(dp[i][j + rod], dp[i - 1][j]);

                    //case 3: Rod used for smaller side
                    if(j < rod) {
                        dp[i][rod - j] = Math.max(dp[i][rod - j], dp[i - 1][j] + j);
                    }
                    else {
                        dp[i][j - rod] = Math.max(dp[i][j - rod], dp[i - 1][j] + rod);
                    }
                }
            }
        }
        return dp[len][0];
    }
}