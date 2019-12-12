package com.vc.hard;

import java.util.*;

class L128 {
    public int longestConsecutive(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                int left = map.getOrDefault(arr[i] - 1, 0);
                int right = map.getOrDefault(arr[i] + 1, 0);

                int total = left + right + 1;
                map.put(arr[i], total);
                map.put(arr[i] - left, total);
                map.put(arr[i] + right, total);

                res = Math.max(res, total);
            }
        }
        return res;
    }
}
