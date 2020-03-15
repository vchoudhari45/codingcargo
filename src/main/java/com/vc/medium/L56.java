package com.vc.medium;

import java.util.*;

class L56 {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            Integer prev = treeMap.floorKey(start);
            if(prev != null && treeMap.get(prev) >= start) {
                start = prev;
            }

            Integer next = treeMap.floorKey(end);
            if(next != null) {
                end = Math.max(end, treeMap.get(next));
            }

            treeMap.subMap(start, end + 1).clear();
            treeMap.put(start, end);
        }

        int[][] res = new int[treeMap.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            res[index][0] = entry.getKey();
            res[index++][1] = entry.getValue();
        }
        return res;
    }
}