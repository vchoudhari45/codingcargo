package com.vc.medium;

import java.util.*;

class L1296 {
    public boolean isPossibleDivide(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        Arrays.sort(arr);
        for (int key : arr) {
            if (map.getOrDefault(key, 0) > 0) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
                //System.out.println("Removing key:"+key+" map is: "+map);
                for (int j = key + 1; j < key + k; j++) {
                    if (map.getOrDefault(j, 0) > 0) {
                        map.put(j, map.get(j) - 1);
                        if (map.get(j) == 0) map.remove(j);
                        //System.out.println("-->Removing next:"+j+" map is: "+map);
                    } else {
                        //System.out.println("-->Not found next:"+j+" map is: "+map);
                        return false;
                    }
                }
            }
        }
        return map.size() == 0;
    }
}
