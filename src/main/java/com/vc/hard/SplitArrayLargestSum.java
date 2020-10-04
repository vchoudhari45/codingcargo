package com.vc.hard;

class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;

        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i = 0; i < nums.length; i++) {
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }

        if(m == 1) return hi;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(isMorePartitions(nums, mid, m)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean isMorePartitions(int[] nums, int sum, int expectedPartitions) {
        int total = 0;
        int partitions = 1;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            if(total > sum) {
                total = nums[i];
                partitions++;
                if(partitions > expectedPartitions) return true;
            }
        }
        return false;
    }
}