package com.vc.easy;

import java.util.Arrays;
import java.util.HashMap;

class L1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < copy.length; i++) {
            if(!map.containsKey(copy[i])) map.put(copy[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }

        return nums;
    }
}
