package com.vc.hard;

import java.util.*;

class IntervalY {
    int[] y;
    boolean isXEnd;
    public IntervalY(int[] y, boolean isXEnd) {
        this.y = y;
        this.isXEnd = isXEnd;
    }

    @Override
    public String toString() {
        return y[0]+" "+y[1]+" "+isXEnd;
    }
}

class Solution {
    public int rectangleArea(int[][] rectangles) {
        TreeMap<Integer, List<IntervalY>> map = new TreeMap<Integer, List<IntervalY>>();
        for(int[] r: rectangles) {
            int x1 = r[0];
            int y1 = r[1];

            int x2 = r[2];
            int y2 = r[3];

            List<IntervalY> listStart = map.getOrDefault(x1, new ArrayList<IntervalY>());
            List<IntervalY> listEnd = map.getOrDefault(x2, new ArrayList<IntervalY>());

            listStart.add(new IntervalY(new int[]{y1, y2}, false));
            listEnd.add(new IntervalY(new int[]{y1, y2}, true));

            map.put(x1, listStart);
            map.put(x2, listEnd);
        }

        // for(Map.Entry<Integer, List<IntervalY>> entry: map.entrySet()) {
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        // }

        long prevX = map.firstKey();
        long sum = 0;
        int MOD = (int)1e9 + 7;
        TreeMap<Integer, Integer> mapY = new TreeMap<Integer, Integer>();
        for(Integer x: map.keySet()) {
            int yDist = calculateYInterval(mapY);
            sum += (x - prevX) % MOD * yDist % MOD;
            sum %= MOD;
            prevX = x;

            List<IntervalY> ys = map.get(x);
            for(IntervalY intervalY: ys) {
                int[] y = intervalY.y;

                int yStart = y[0];
                int yEnd = y[1];

                Integer count = mapY.get(yStart);
                if(count == null) count = 0;
                count += intervalY.isXEnd ? -1 : 1;
                if(count == 0) mapY.remove(yStart);
                else mapY.put(yStart, count);

                count = mapY.get(yEnd);
                if(count == null) count = 0;
                count += intervalY.isXEnd ? 1 : -1;
                if(count == 0) mapY.remove(yEnd);
                else mapY.put(yEnd, count);
            }
        }
        return (int)sum;
    }

    public int calculateYInterval(TreeMap<Integer, Integer> map) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(Integer y: map.keySet()) {
            boolean isEnd = map.get(y) < 0;
            count += map.get(y);
            if(isEnd) max = Math.max(max, y);
            else min = Math.min(min, y);
            if(count == 0) {
                res += max - min;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            }
        }
        return res;
    }
}