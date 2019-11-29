package com.vc.hard;

import java.util.*;

class L757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int min = -1, max = -1, ans = 0;
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //System.out.println(start+" "+ end);
            if(start > max) {
                ans += 2;
                min = end - 1;
                max = end;
            }
            else if(start > min) {
                ans++;
                min = max == end ? max - 1: max;
                max = end;
            }
        }
        return ans;
    }
}
