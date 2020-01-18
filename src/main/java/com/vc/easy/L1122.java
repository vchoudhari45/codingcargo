package com.vc.easy;

import java.util.*;

class L1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        int index = 0;
        for(int i = 0; i < arr2.length; i++) {
            if(map.getOrDefault(arr2[i], 0) > 0) {
                for(int j = 0; j < map.get(arr2[i]); j++) {
                    arr1[index++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            for(int j = 0; j < entry.getValue(); j++) {
                arr1[index++] = entry.getKey();
            }
        }
        return arr1;
    }
}
