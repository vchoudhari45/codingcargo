package com.vc.hard;

class MaximumSumOfNonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int nk = n - k + 1;

        int[] sum = new int[nk];
        int sumValue = 0;
        for(int i = 0; i < k; i++) sumValue += nums[i];
        for(int i = k; i <= n; i++) {
            sum[i - k] = sumValue;
            sumValue -= nums[i - k];
            if(i < n) sumValue += nums[i];
        }

        int[] left = new int[nk];
        int maxValue = Integer.MIN_VALUE;
        int bestIndex = 0;
        for(int i = 0; i < nk; i++) {
            if(maxValue < sum[i]) {
                maxValue = sum[i];
                bestIndex = i;
            }
            left[i] = bestIndex;
        }

        int[] right = new int[nk];
        maxValue = Integer.MIN_VALUE;
        bestIndex = 0;
        for(int i = nk - 1; i >= 0; i--) {
            if(maxValue <= sum[i]) {
                maxValue = sum[i];
                bestIndex = i;
            }
            right[i] = bestIndex;
        }

        maxValue = Integer.MIN_VALUE;
        int[] res = new int[3];
        for(int i = k; i + k < sum.length; i++) {
            int leftValue = sum[left[i - k]];
            int middleValue = sum[i];
            int rightValue = sum[right[i + k]];
            if(maxValue < leftValue + middleValue + rightValue) {
                maxValue = leftValue + middleValue + rightValue;
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }

        return res;
    }
}