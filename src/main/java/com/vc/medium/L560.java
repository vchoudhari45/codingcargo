package com.vc.medium;

import java.util.HashMap;

class L560 {
    public int subarraySum(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;

        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        int runningSum = 0, res = 0;
        for(int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if(prefix.containsKey(runningSum - k)) {
                res += prefix.get(runningSum - k);
            }
            prefix.put(runningSum, prefix.getOrDefault(runningSum, 0) + 1);
        }
        return res;
    }
}
