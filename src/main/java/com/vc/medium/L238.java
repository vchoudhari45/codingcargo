package com.vc.medium;

class L238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int runningProduct = 1;
        for(int i = 0; i < n; i++) {
            left[i] = runningProduct;
            runningProduct *= nums[i];
        }

        runningProduct = 1;
        for(int i = n - 1; i >= 0; i--) {
            right[i] = runningProduct;
            runningProduct *= nums[i];
        }

        int[] res = new int[n];
        for(int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
