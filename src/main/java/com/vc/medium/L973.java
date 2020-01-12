package com.vc.medium;

import java.util.*;

class L973 {
    static class Point {
        int x;
        int y;
        double distance;

        Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return x+" "+" "+y+" "+distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return Double.valueOf(p1.distance).compareTo(p2.distance);
            }
        });

        for(int[] point: points) {
            int x = point[0];
            int y = point[1];
            double distance = distance(x, y);
            pq.offer(new Point(x, y, distance));
        }

        int size = Math.min(pq.size(), K);
        int[][] res = new int[size][2];
        for(int i = 0; i < size; i++) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }

    private double distance(int x, int y) {
        int dx = Math.abs(x);
        int dy = Math.abs(y);
        return Math.pow(dx, 2) + Math.pow(dy, 2);
    }
}
