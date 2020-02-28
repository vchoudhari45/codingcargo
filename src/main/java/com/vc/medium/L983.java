package com.vc.medium;

import java.util.*;

class L983 {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        for(int i = 0; i < days.length; i++) daySet.add(days[i]);

        int[] dp = new int[366];
        for(int i = 1; i < 366; i++) {
            if(daySet.contains(i)) {
                dp[i] = dp[i - 1] + costs[0];

                int day7DayAgo = Math.max(i - 7, 0);
                dp[i] = Math.min(dp[i], dp[day7DayAgo] + costs[1]);

                int day30DayAgo = Math.max(i - 30, 0);
                dp[i] = Math.min(dp[i], dp[day30DayAgo] + costs[2]);
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[365];
    }
}
