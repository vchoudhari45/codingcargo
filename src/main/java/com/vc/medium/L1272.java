package com.vc.medium;

import java.util.*;

class L1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval: intervals) {
            map.put(interval[0], interval[1]);
        }

        Integer next = map.floorKey(toBeRemoved[1]);
        if(next != null && map.get(next) > toBeRemoved[1]) {
            map.put(toBeRemoved[1], map.get(next));
        }
        Integer pre = map.floorKey(toBeRemoved[0]);
        if(pre != null && map.get(pre) > toBeRemoved[0]) {
            map.put(pre, toBeRemoved[0]);
        }
        map.subMap(toBeRemoved[0], true, toBeRemoved[1], false).clear();

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            List<Integer> interval = new ArrayList<>();
            interval.add(entry.getKey());
            interval.add(entry.getValue());
            res.add(interval);
        }
        return res;
    }
}
