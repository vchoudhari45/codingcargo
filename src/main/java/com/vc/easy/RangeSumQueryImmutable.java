package com.vc.easy;

class RangeSumQueryImmutable {
    int[] prefixArr;
    public RangeSumQueryImmutable(int[] nums) {
        prefixArr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefixArr[i + 1] = prefixArr[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefixArr[j + 1] - prefixArr[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */