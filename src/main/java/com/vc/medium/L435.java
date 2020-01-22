package com.vc.medium;

import java.util.*;

class L435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int cmp = Integer.compare(x[1], y[1]);
                if(cmp == 0) {
                    cmp = Integer.compare(x[0], y[0]);
                }
                return cmp;
            }
        });

        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++) {
            if(prev > intervals[i][0]) count++;
            else prev = intervals[i][1];
        }
        return count;
    }
}
