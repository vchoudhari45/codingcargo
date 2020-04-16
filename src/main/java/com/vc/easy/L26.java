package com.vc.easy;

class L26 {
    public int removeDuplicates(int[] nums) {
        int prev = 0, current = 0;
        while(current < nums.length) {
            if(nums[prev] == nums[current]) {
                current++;
            }
            else {
                prev++;
                nums[prev] = nums[current++];
            }
        }
        return prev + 1;
    }
}
