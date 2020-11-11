package com.vc.hard;

import java.util.Arrays;

class FindKThSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0;
        int hi = nums[n - 1] - nums[0];
        while(lo < hi) {
            int distance = lo + (hi - lo) / 2;
            if(isDistanceIndexSmallerThanK(nums, distance, k)) lo = distance + 1;
            else hi = distance;
        }
        return lo;
    }

    private boolean isDistanceIndexSmallerThanK(int[] nums, int distance, int k) {
        int left = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++) {
            while(nums[right] - nums[left] > distance) left++;
            count += right - left;
        }
        return count < k;
    }
}