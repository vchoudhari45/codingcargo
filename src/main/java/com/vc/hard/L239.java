package com.vc.hard;

import java.util.*;

class L239 {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr.length == 0) return new int[0];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] res = new int[arr.length - k + 1];
        int index = 0;
        for(int i = k; i < arr.length; i++) {
            res[index++] = map.lastKey();
            if(map.get(arr[i - k]) > 1) map.put(arr[i - k], map.get(arr[i - k]) - 1);
            else map.remove(arr[i - k]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        res[res.length - 1] = map.lastKey();
        return res;
    }
}