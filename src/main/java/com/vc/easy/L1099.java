package com.vc.easy;

import java.util.*;

class L1099 {
    public int twoSumLessThanK(int[] arr, int K) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int sum = -1;
        for(int i = 0; i < arr.length; i++) {
            int e1 = arr[i];
            Integer e2 = map.floorKey(K - e1 - 1);
            if(e2 != null) {
                if(e1 != e2 || map.get(e2) > 1){
                    sum = Math.max(sum, e1 + e2);
                }
            }
        }
        return sum;
    }
}
