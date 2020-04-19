package com.vc.medium;

class L1060 {
    public int missingElement(int[] nums, int index) {
        int n = nums.length;

        if(index > missing(nums, n - 1)) return nums[n - 1] + index - missing(nums, n - 1);

        int lo = 0;
        int hi = n - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(missing(nums, mid) < index) lo = mid + 1;
            else hi = mid;
        }

        return nums[lo - 1] + index - missing(nums, lo - 1);
    }

    private int missing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}