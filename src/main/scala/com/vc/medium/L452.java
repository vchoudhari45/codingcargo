package com.vc.medium;

import java.util.*;

class L452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        int arrowCount = 0;
        long arrowLocation = Long.MIN_VALUE;
        for(int i = 0; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            //System.out.println("start: "+start+" end: "+end+" arrowLocation: "+arrowLocation);
            if(start > arrowLocation) {
                arrowCount++;
                arrowLocation = end;
                //System.out.println(arrowLocation+" "+arrowCount);
            }
        }
        return arrowCount;
    }
}