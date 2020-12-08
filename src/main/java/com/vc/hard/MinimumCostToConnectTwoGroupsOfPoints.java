package com.vc.hard;

import java.util.*;

class MinimumCostToConnectTwoGroupsOfPoints {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size();
        int size2 = cost.get(0).size();

        int[] dp = new int[(1 << size2)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //Iterate over all the elements from group1
        for(int group1 = 0; group1 < size1; group1++) {
            int[] current = new int[(1 << size2)];
            Arrays.fill(current, Integer.MAX_VALUE);

            //For each element in a group1 there are 2^group2 possibilities
            //Because each element from group1 can connect to one or more element from group2
            for(int group2 = 0; group2 < size2; group2++) {

                //Iterate over all 2^group2 possibilities
                for(int mask = 0; mask < (1 << size2); mask++) {
                    int newMask = mask | (1 << group2);

                    //If group2 element is not connected in a current mask,
                    //You can derive newMask from current mask
                    if((mask & (1 << group2)) == 0) {
                        if(current[mask] != Integer.MAX_VALUE) {
                            current[newMask] = Math.min(current[newMask],
                                    current[mask] + cost.get(group1).get(group2));
                        }
                    }

                    //Check if newMask value can be reduced further by using previous row state
                    if(dp[mask] != Integer.MAX_VALUE) {
                        current[newMask] = Math.min(current[newMask],
                                dp[mask] + cost.get(group1).get(group2));
                    }
                }
            }
            dp = current;
        }

        return dp[(1 << size2) - 1];
    }
}