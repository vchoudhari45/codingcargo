package com.vc.easy;

class L283 {
    public void moveZeroes(int[] nums) {
        int insertIndex = 0, i = 0;
        while(i < nums.length) {
            if(nums[i] != 0) nums[insertIndex++] = nums[i];
            i++;
        }

        while(insertIndex < nums.length) {
            nums[insertIndex] = 0;
            insertIndex++;
        }
    }
}
