package com.vc.medium;

class L162 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        if(n == 1) return 0;
        for(int i = 0; i < nums.length; i++) {
            int prev = i > 0 ? nums[i - 1] : Integer.MIN_VALUE;
            int next = i + 1 < n ? nums[i + 1] : Integer.MIN_VALUE;
            if(prev < nums[i] && nums[i] > next) return i;
        }
        return -1;
    }
}
