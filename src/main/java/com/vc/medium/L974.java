package com.vc.medium;

import java.util.HashMap;

class L974 {
    public int subarraysDivByK(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int n = arr.length, count = 0, runningSum = 0;
        for(int i = 0; i < n; i++) {
            runningSum = (runningSum + arr[i]) % K;
            if(runningSum < 0) runningSum = runningSum + K;
            count += map.getOrDefault(runningSum, 0);
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}
