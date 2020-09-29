package com.vc.hard;

import java.util.*;

class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> prefixSum = new TreeMap<>();
        long sum = 0;
        int count = 0;
        prefixSum.put(0l, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Integer> subMap = prefixSum.subMap(from, true, to, true);
            for(int value: subMap.values()) count += value;
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}