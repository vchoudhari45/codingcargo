package com.vc.hard;

import java.util.*;

class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            int[] p1 = points[i];

            HashMap<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int maxInternal = 0;

            for(int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                int x = p1[0] - p2[0];
                int y = p1[1] - p2[1];

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
                maxInternal = Math.max(maxInternal, map.get(key));
            }
            max = Math.max(max, maxInternal + overlap + 1);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}