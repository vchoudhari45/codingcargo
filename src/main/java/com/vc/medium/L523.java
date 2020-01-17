package com.vc.medium;

import java.util.*;

class L523 {
    public boolean checkSubarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for(int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if(k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if(prev != null) {
                if(i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
