package com.vc.medium;

import java.util.*;
class L954 {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key: map.keySet()) {
            if(map.get(key) == 0) continue;
            int element = key;
            int want = element < 0 ? element / 2 : 2 * element;
            if(element < 0 && element % 2 != 0) continue;
            if(map.getOrDefault(want, 0) >= map.getOrDefault(key, 0)) {
                map.put(want, map.get(want) - map.get(key));
                map.put(key, 0);
            }
            else return false;
        }
        for(Integer value: map.values()) if(value != 0) return false;
        return true;
    }
}
