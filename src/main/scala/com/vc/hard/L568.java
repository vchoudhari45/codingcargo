package com.vc.hard;

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        /**

                 flights[i][j] Represents if there is flight from city i to j
                 flights [
                     [0,1,1],
                     [1,0,1],
                     [1,1,0]
                 ]

                 days[i][j] Represents the maximum days you could take vacation in the city i in the week j.
                 days [
                     [1,3,1],
                     [6,0,3],
                     [3,3,3]
                 ]

                 Cities = flights.length;
                 Weeks  = days[0].length;
         */

        if(days == null || days.length == 0 || flights == null || flights.length == 0) return 0;

        int cities = flights.length;
        int weeks = days[0].length;
        int[][] dp = new int[weeks][cities];
        boolean[][] isInCity = new boolean[cities][weeks];
        int res = Integer.MIN_VALUE;

        for(int toCity = 0; toCity < cities; toCity++) {
            if(toCity == 0 || flights[0][toCity] == 1) {
                dp[0][toCity] = days[toCity][0];
                isInCity[toCity][0] = true;
            }
        }

        for(int week = 1; week < weeks; week++) {
            for(int fromCity = 0; fromCity < cities; fromCity++) {
                for(int toCity = 0; toCity < cities; toCity++) {
                    if((fromCity == toCity || flights[fromCity][toCity] == 1) && isInCity[fromCity][week - 1]) {
                        dp[week][toCity] = Math.max(dp[week - 1][fromCity] + days[toCity][week], dp[week][toCity]);
                        isInCity[toCity][week] = true;
                    }
                }
            }
        }

        for(int i = 0; i < cities; i++) {
            res = Math.max(res, dp[weeks - 1][i]);
        }
        return res;
    }
}