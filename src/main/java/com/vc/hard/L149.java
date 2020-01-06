package com.vc.hard;

import java.util.*;

class L149 {
    public int maxPoints(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        int max = 0;
        int overlap = 0;
        for(int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            overlap = 0;
            max = 0;
            map.clear();

            for(int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                int x = p2[0] - p1[0];
                int y = p2[1] - p1[1];

                if(x == 0 && y == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(x, y);

                if(gcd != 0) {
                    x = x / gcd;
                    y = y / gcd;
                }

                String key = x+"~"+y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));

                // System.out.println("P1: ("+p1[0]+", "+p1[1]
                //                    +") P2: ("+p2[0]+", "+p2[1]
                //                    +" xOld: "+(p2[0] - p1[0])
                //                    +" yOld: "+(p2[1] - p1[1])
                //                    +") x: "+x
                //                    +" y: "+y
                //                    +" gcd: "+gcd
                //                    +" max: "+max
                //                    +" map: "+map);
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
