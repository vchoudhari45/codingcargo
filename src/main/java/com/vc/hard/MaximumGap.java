package com.vc.hard;

class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        int n = nums.length;
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            minValue = Math.min(nums[i], minValue);
            maxValue = Math.max(nums[i], maxValue);
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        int avgGap = (int)Math.ceil((double)(maxValue - minValue) / (n - 1));
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == minValue || nums[i] == maxValue) continue;

            int bucketIndex = (nums[i] - minValue) / avgGap;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], nums[i]);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], nums[i]);
        }

        int maxGap = Integer.MIN_VALUE;
        int prev = minValue;
        for(int i = 0; i < nums.length; i++) {
            if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;

            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        maxGap = Math.max(maxGap, maxValue - prev);
        return maxGap;
    }
}