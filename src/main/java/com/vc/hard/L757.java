package com.vc.hard;

import java.util.*;

class L757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.valueOf(x[1]).compareTo(y[1]);
            }
        });

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start > max) {
                ans += 2;
                min = end - 1;
                max = end;
            }
            else if(start > min) {
                ans++;
                min = max == end ? end - 1 : max;
                max = end;
            }
            else if(start < min) {
                //Not possible intervals are sorted by end of the interval
            }
            //System.out.println("start: "+start+" end: "+end+" min: "+min+" max: "+max);
        }
        return ans;
    }
}