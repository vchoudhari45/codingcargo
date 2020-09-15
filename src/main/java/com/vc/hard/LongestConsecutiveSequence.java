package com.vc.hard;

import java.util.*;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;

            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);

            int total = left + right + 1;
            map.put(nums[i], total);
            map.put(nums[i] - left, total);
            map.put(nums[i] + right, total);

            res = Math.max(res, total);
        }
        return res;
    }
}