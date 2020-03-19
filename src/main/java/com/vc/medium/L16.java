package com.vc.medium;

import java.util.Arrays;

class L16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int n = nums.length, diff = Integer.MAX_VALUE, sum = 0;
        for(int first = 0; first < n; first++) {
            int second = first + 1, third = n - 1;
            while(second < third) {
                int s = nums[first] + nums[second] + nums[third];
                if(Math.abs(target - s) < diff) {
                    diff = Math.abs(target - s);
                    sum = s;
                }
                if(s > target) third--;
                else if(s < target) second++;
                else return target;
            }
        }
        return sum;
    }
}