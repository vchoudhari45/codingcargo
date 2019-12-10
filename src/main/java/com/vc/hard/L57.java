package com.vc.hard;

import java.util.*;

class L57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<int[]>();
        int n = intervals.length;

        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        while(i < n && start > intervals[i][1]) {
            output.add(intervals[i++]);
        }
        int newStart = i < n ? Math.min(start, intervals[i][0]) : start;

        while(i < n && end >= intervals[i][0]) i++;
        int newEnd = (i - 1) >= 0 ? Math.max(end, intervals[i - 1][1]) : end;

        output.add(new int[]{newStart, newEnd});
        while(i < n) {
            output.add(intervals[i++]);
        }

        int[][] res = new int[output.size()][2];
        for(int k = 0; k < output.size(); k++) {
            int[] r = output.get(k);
            res[k][0] = r[0];
            res[k][1] = r[1];
        }
        return res;
    }
}
