package com.vc.easy;

class L88 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int lo = 0;
        int hi = n;

        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            //System.out.println(lo+" "+mid+" "+hi);

            int missing = nums[mid] - nums[lo] - (mid - lo);
            if(missing >= k) {
                hi = mid;
            }
            else {
                k-= missing;
                lo = mid;
            }
        }

        return nums[lo] + k;
    }
}