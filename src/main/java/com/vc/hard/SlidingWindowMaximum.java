package com.vc.hard;

import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < k; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i = k; i < n; i++) {
            //Take max element from the treeMap
            res[i - k] = treeMap.lastKey();

            //Remove (i - k)th element from treeMap
            int toRemove = nums[i - k];
            treeMap.put(toRemove, treeMap.getOrDefault(toRemove, 0) - 1);
            if(treeMap.get(toRemove) == 0) treeMap.remove(toRemove);

            //Add ith element into treeMap
            int toAdd = nums[i];
            treeMap.put(toAdd, treeMap.getOrDefault(toAdd, 0) + 1);
        }
        res[n - k] = treeMap.lastKey();
        return res;
    }
}