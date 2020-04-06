package com.vc.medium;

import java.util.*;

class L368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();

        int n = nums.length;

        Arrays.sort(nums);

        List<Integer>[] dp = new List[n];
        for(int i = 0; i < n; i++) dp[i] = new ArrayList<>();

        //Longest increasing Subsequence like
        for(int i = 0; i < n; i++) {
            List<Integer> maxSet = new ArrayList<>();

            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && maxSet.size() < dp[j].size()) {
                    maxSet = dp[j];
                }
            }

            dp[i].addAll(maxSet);
            dp[i].add(nums[i]);
            //System.out.println(Arrays.toString(dp));
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dp[i].size() > res.size()) {
                res = dp[i];
            }
        }
        return res;
    }
}