package com.vc.hard;

import java.util.*;

class L391 {
    public boolean isRectangleCover(int[][] rectangle) {
        HashSet<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;

        for(int[] arr: rectangle) {
            x1 = Math.min(x1, arr[0]);
            y1 = Math.min(y1, arr[1]);
            x2 = Math.max(x2, arr[2]);
            y2 = Math.max(y2, arr[3]);

            String s1 = arr[0] + " " + arr[1];
            String s2 = arr[2] + " " + arr[3];
            String s3 = arr[0] + " " + arr[3];
            String s4 = arr[2] + " " + arr[1];

            if(!set.add(s1)) set.remove(s1);
            if(!set.add(s2)) set.remove(s2);
            if(!set.add(s3)) set.remove(s3);
            if(!set.add(s4)) set.remove(s4);

            area += (arr[2] - arr[0]) * (arr[3] - arr[1]);
        }

        String s1 = x1 + " " + y1;
        String s2 = x2 + " " + y2;
        String s3 = x1 + " " + y2;
        String s4 = x2 + " " + y1;

        if(!set.contains(s1)
                || !set.contains(s2) || !set.contains(s3) || !set.contains(s4)
                || set.size() != 4) return false;

        return (x2 - x1) * (y2 - y1) == area;
    }
}