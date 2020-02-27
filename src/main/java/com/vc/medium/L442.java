package com.vc.medium;

import java.util.*;

class L442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) res.add(index + 1);
            else nums[index] = -1 * nums[index];
        }
        return res;
    }
}
