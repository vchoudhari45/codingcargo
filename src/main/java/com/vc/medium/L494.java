package com.vc.medium;

import java.util.HashMap;

class L494 {
    HashMap<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int S) {
        this.memo = new HashMap<>();
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0, S);
    }

    private int helper(int[] nums, int index, int current, int target) {
        if(index == nums.length) {
            if(current == target) return 1;
            else return 0;
        }

        String key = index + " " + current;
        if(memo.containsKey(key)) return memo.get(key);

        int left = helper(nums, index + 1, current + nums[index], target);
        int right = helper(nums, index + 1, current - nums[index], target);

        memo.put(key, left + right);
        return left + right;
    }
}