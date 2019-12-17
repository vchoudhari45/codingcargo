package com.vc.hard;

import java.util.*;

class L327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> prefixSum = new TreeMap<>();
        prefixSum.put(0l, 1);
        long sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Integer> submap = prefixSum.subMap(from, true, to, true);
            for(int values: submap.values()) {
                count += values;
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
