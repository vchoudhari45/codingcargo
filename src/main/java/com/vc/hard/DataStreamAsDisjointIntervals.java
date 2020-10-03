package com.vc.hard;

import java.util.*;

class DataStreamAsDisjointIntervals {

    TreeMap<Integer, int[]> treeMap;

    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        this.treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if(treeMap.containsKey(val)) return;

        Integer l = treeMap.lowerKey(val);
        Integer h = treeMap.higherKey(val);

        if(l != null && h != null && treeMap.get(l)[1] + 1 == val && h == val + 1) {
            treeMap.get(l)[1] = treeMap.get(h)[1];
            treeMap.remove(h);
        }
        else if(l != null && treeMap.get(l)[1] + 1 >= val) {
            treeMap.get(l)[1] = Math.max(treeMap.get(l)[1], val);
        }
        else if(h != null && h == val + 1) {
            treeMap.put(val, new int[]{val, treeMap.get(h)[1]});
            treeMap.remove(h);
        }
        else {
            treeMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][2];
        int index = 0;
        for(int[] element: treeMap.values()) {
            res[index++] = element;
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