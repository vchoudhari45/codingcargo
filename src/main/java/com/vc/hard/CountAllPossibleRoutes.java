package com.vc.hard;

import java.util.Arrays;

class CountAllPossibleRoutes {
    private int MOD = (int)1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        /**
            Bottom up Dynamic Programming
            dp[i][j]: Number of way you can reach finish from ith position with j quantity of fuel
         */
        int[][] dp = new int[n][fuel + 1];

        /**
            We can reach to finish from finish with even zero quantity of fuel,
            so assign 1 for dp[finish][Any quantity of fuel]
         */
         Arrays.fill(dp[finish], 1);

        for(int startingFuel = 0; startingFuel <= fuel; startingFuel++) {
            for(int from = 0; from < n; from++) {
                for(int to = 0; to < n; to++) {
                    if(from == to) continue;
                    int requiredFuel = Math.abs(locations[from] - locations[to]);
                    if(startingFuel >= requiredFuel) {
                        dp[from][startingFuel] = (dp[from][startingFuel] + dp[to][startingFuel - requiredFuel]) % MOD;
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}