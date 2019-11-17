package com.vc.hard;

import java.util.*;

class L391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        long area = 0;
        HashSet<String> set = new HashSet<String>();
        for(int[] r: rectangles) {
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);

            String s1 = r[0] +" "+ r[1];
            String s2 = r[0] +" "+ r[3];
            String s3 = r[2] +" "+ r[1];
            String s4 = r[2] +" "+ r[3];

            if(!set.contains(s1)) set.add(s1);
            else set.remove(s1);

            if(!set.contains(s2)) set.add(s2);
            else set.remove(s2);

            if(!set.contains(s3)) set.add(s3);
            else set.remove(s3);

            if(!set.contains(s4)) set.add(s4);
            else set.remove(s4);

            area += (r[2] - r[0]) * (r[3] - r[1]);
        }

        String s1 = x1 +" "+ y1;
        String s2 = x1 +" "+ y2;
        String s3 = x2 +" "+ y1;
        String s4 = x2 +" "+ y2;

        System.out.println(set);

        if(!set.contains(s1)
                || !set.contains(s2) || !set.contains(s3) || !set.contains(s4) || set.size() != 4) return false;

        return area == (x2 - x1) * (y2 - y1);
    }
}
