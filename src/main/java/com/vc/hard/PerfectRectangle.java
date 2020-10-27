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
        HashSet<String> points = new HashSet<>();
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

            if(!points.add(point1)) points.remove(point1);
            if(!points.add(point2)) points.remove(point2);
            if(!points.add(point3)) points.remove(point3);
            if(!points.add(point4)) points.remove(point4);

            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
        }

        String point1 = x1 +" "+ y1;
        String point2 = x2 +" "+ y2;
        String point3 = x1 +" "+ y2;
        String point4 = x2 +" "+ y1;

        if(!points.contains(point1) || !points.contains(point2) || !points.contains(point3) || !points.contains(point4) || points.size() != 4) return false;

        return area == (x2 - x1) * (y2 - y1);
    }
}