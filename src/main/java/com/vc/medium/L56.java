package com.vc.medium;

import java.util.*;

class L56 {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            Integer pre = map.floorKey(start);
            if(pre != null && map.get(pre) >= start) {
                start = pre;
            }

            Integer next = map.floorKey(end);
            if(next != null && end >= next) {
                end = Math.max(map.get(next), end);
            }
            map.subMap(start, end + 1).clear();
            map.put(start, end);
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res[index][0] = entry.getKey();
            res[index++][1] = entry.getValue();
        }
        return res;
    }
}
