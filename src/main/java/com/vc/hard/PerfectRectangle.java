package com.vc.hard;

import java.util.*;

class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        /**
             Input rectangles array should satisfy below three criteria
             1. the large rectangle area should be equal to the sum of all small input rectangles
             2. count of all the points should be even
             3. count of of all the four corner points should be one
         */
        HashSet<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        int area = 0;
        for(int[] rectangle: rectangles) {
            x1 = Math.min(x1, rectangle[0]);
            y1 = Math.min(y1, rectangle[1]);
            x2 = Math.max(x2, rectangle[2]);
            y2 = Math.max(y2, rectangle[3]);

            String point1 = rectangle[0] +" "+ rectangle[1];
            String point2 = rectangle[2] +" "+ rectangle[3];
            String point3 = rectangle[0] +" "+ rectangle[3];
            String point4 = rectangle[2] +" "+ rectangle[1];

            if(!set.add(point1)) set.remove(point1);
            if(!set.add(point2)) set.remove(point2);
            if(!set.add(point3)) set.remove(point3);
            if(!set.add(point4)) set.remove(point4);

            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
        }

        String point1 = x1 +" "+ y1;
        String point2 = x2 +" "+ y2;
        String point3 = x1 +" "+ y2;
        String point4 = x2 +" "+ y1;

        if(!set.contains(point1) || !set.contains(point2) || !set.contains(point3) || !set.contains(point4) || set.size() != 4) return false;

        return area == (x2 - x1) * (y2 - y1);
    }
}