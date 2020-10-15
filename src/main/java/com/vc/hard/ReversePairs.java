package com.vc.hard;

class ReversePairs {
    private int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    private int[] mergeSort(int[] nums) {
        if(nums.length <= 1) return nums;

        int lo = 0;
        int hi = nums.length;

        int mid = lo + (hi - lo) / 2;
        int[] left = mergeSort(slice(lo, mid, nums));
        int[] right = mergeSort(slice(mid, hi, nums));

        int l = 0, r = 0;
        int[] res = new int[nums.length];
        while(l < left.length) {
            double leftElement = (double)left[l] / 2.0;
            /**
             *  It means if left[l] > right[r] that also means [left + 1] > right[r]
             *  because left[l] <= left[l + 1] as we sort later
             **/
            while(r < right.length && leftElement > right[r]) r++;
            l++;
            count += r;
        }

        l = 0;
        r = 0;
        int index = 0;
        while(l < left.length && r < right.length) {
            if(left[l] > right[r]) res[index++] = right[r++];
            else res[index++] = left[l++];
        }
        while(l < left.length) res[index++] = left[l++];
        while(r < right.length) res[index++] = right[r++];
        return res;
    }

    private int[] slice(int from, int to, int[] nums) {
        int[] res = new int[to - from];
        int index = 0;
        for(int i = from; i < to; i++) {
            res[index++] = nums[i];
        }
        return res;
    }
}