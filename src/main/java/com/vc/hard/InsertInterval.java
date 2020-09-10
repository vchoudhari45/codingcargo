package com.vc.hard;

import java.util.*;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        //Output
        List<int[]> output = new ArrayList<>();

        //Interval to insert
        int start = newInterval[0];
        int end = newInterval[1];

        int index = 0;
        //Adding Non-Overlapping interval
        while(index < n && start > intervals[index][1]) {
            output.add(intervals[index++]);
        }

        //Merging Interval
        int newStart = index < n ? Math.min(intervals[index][0], start) : start;
        while(index < n && end >= intervals[index][0]) index++;
        int newEnd = index - 1 >= 0 ? Math.max(intervals[index - 1][1], end) : end;
        output.add(new int[]{newStart, newEnd});


        //Adding Remaining intervals
        while(index < n) output.add(intervals[index++]);

        int[][] res = new int[output.size()][2];
        for(int i = 0; i < output.size(); i++) res[i] = output.get(i);

        return res;
    }
}