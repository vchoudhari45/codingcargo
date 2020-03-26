package com.vc.medium;

import java.util.*;

class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;

        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if(k != 0) runningSum = runningSum % k;
            if(prefix.containsKey(runningSum)) {
                if(i - prefix.get(runningSum) > 1) return true;
            }
            else prefix.put(runningSum, i);
        }
        return false;
    }
}
