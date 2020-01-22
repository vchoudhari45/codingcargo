package com.vc.medium;

import java.util.*;

class L1218 {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i] - difference)) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i] - difference) + 1);
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}
