package com.vc.hard;

import java.util.*;

class DistributeRepeatingIntegers {
    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        int[] count = new int[freqMap.size()];
        int index = 0;
        for(int value: freqMap.values()) count[index++] = value;

        Arrays.sort(quantity);
        return helper(quantity, count, quantity.length - 1);
    }

    private boolean helper(int[] quantity, int[] count, int qIndex) {
        if(qIndex == -1) return true;

        for(int i = 0; i < count.length; i++) {
            int required = quantity[qIndex];

            if(count[i] >= required) {
                count[i] -= required;

                if(helper(quantity, count, qIndex - 1)) return true;

                count[i] += required;
            }
        }
        return false;
    }
}