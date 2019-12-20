package com.vc.easy;

import java.util.*;

class L1 {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i])) return new int[] {map.get(target - arr[i]), i};
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
}