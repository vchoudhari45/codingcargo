package com.vc.hard;

import java.util.*;

class SummaryRanges {
    List<int[]> list = new ArrayList<int[]>();
    HashSet<Integer> set = new HashSet<>();

    public void addNum(int val) {
        if(set.add(val)) {
            int i = 0;
            for(i = 0; i < list.size(); i++) {
                int[] interval = list.get(i);
                if(val < interval[1]) break;
            }
            int[] prev = i == 0 ? new int[]{val, val} : list.get(i - 1);
            int[] next = i == list.size() ? new int[]{val, val} : list.get(i);
            if(prev[1] + 1 == val && next[0] - 1== val) {
                list.remove(i - 1);
                list.remove(i - 1);
                list.add(i - 1, new int[]{prev[0], next[1]});
            }
            else if(next[0] - 1 == val) {
                list.remove(i);
                list.add(i, new int[]{val, next[1]});
            }
            else if(prev[1] + 1 == val) {
                list.remove(i - 1);
                list.add(i - 1, new int[]{prev[0], val});
            }
            else {
                list.add(i, new int[]{val, val});
            }
        }
    }

    public int[][] getIntervals() {
        int[][] arr = new int[list.size()][2];
        int index = 0;
        for(int[] i: list) {
            arr[index++] = i;
        }
        return arr;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */