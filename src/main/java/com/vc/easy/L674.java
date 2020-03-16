package com.vc.easy;

class L674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int prev = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]) {
                max = Math.max(max, prev + 1);
                prev++;
            }
            else prev = 1;
        }
        return max;
    }
}
