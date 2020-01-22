package com.vc.medium;

class L264 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[index2] * 2, nums[index3] * 3), nums[index5] * 5);
            if(nums[i] == nums[index2] * 2) index2++;
            if(nums[i] == nums[index3] * 3) index3++;
            if(nums[i] == nums[index5] * 5) index5++;
        }
        //for(int i = 0; i < n; i++) System.out.println(nums[i]);
        return nums[n - 1];
    }
}
