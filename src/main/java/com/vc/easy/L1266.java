package com.vc.easy;

class L1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length <= 1) return 0;

        int res = 0;
        for(int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            int[] current = points[i];
            int distance = getDistance(prev, current);
            res += distance;
        }

        return res;
    }

    private int getDistance(int[] prev, int[] current) {
        return Math.max(Math.abs(prev[0] - current[0]), Math.abs(prev[1] - current[1]));
    }
}
