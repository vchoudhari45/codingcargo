package com.vc.hard;

import java.util.*;

class SummaryRanges {
    TreeMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<Integer, Integer>();
    }

    public void addNum(int val) {
        Integer pre = map.floorKey(val);
        Integer next = map.ceilingKey(val);

        if(pre != null && map.get(pre) >= val) return;
        if(next != null && next == val) return;

        int start = val;
        int end = val;

        if(pre != null && map.get(pre) + 1 == val) {
            start = pre;
            map.remove(pre);
        }

        if(next != null && next - 1 == val) {
            end = map.get(next);
            map.remove(next);
        }

        map.put(start, end);
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];

        int i = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i++][1] = entry.getValue();
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
