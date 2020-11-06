package com.vc.hard;

class MaximumAverageSubarrayIi {
    public double findMaxAverage(int[] nums, int k) {
        double lo = Integer.MAX_VALUE;
        double hi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            lo = Math.min(lo, nums[i]);
            hi = Math.max(hi, nums[i]);
        }


        double avg = 0;
        while(hi - lo > 1e-5) {
            avg = lo + (hi - lo) / 2;
            if(isLargerAvgPossible(nums, k, avg)) lo = avg;
            else hi = avg;
        }
        return lo;
    }

    private boolean isLargerAvgPossible(int[] arr, int k, double avg) {
        double[] remaining = new double[arr.length];
        for(int i = 0; i < arr.length; i++) {
            remaining[i] = arr[i] - avg;
        }

        //After removing avg, check if rightSum can be > 0
        double rightSum = 0;
        double leftSum = 0;
        for(int i = 0; i < k; i++) rightSum += remaining[i];
        if(rightSum >= 0) return true;

        for(int i = k; i < arr.length; i++) {
            rightSum += remaining[i];
            leftSum += remaining[i - k];
            if(leftSum < 0) {
                rightSum -= leftSum;
                leftSum = 0;
            }
            if(rightSum >= 0) return true;
        }
        return false;
    }
}