package com.vc.easy;

import java.util.*;

class L1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> seen = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(!seen.add(entry.getValue())) return false;
        }
        return true;
    }
}
