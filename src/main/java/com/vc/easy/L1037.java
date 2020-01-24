package com.vc.easy;

class L1037 {
    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        return (p1[0] - p2[0]) * (p1[1] - p3[1]) !=  (p1[1] - p2[1]) * (p1[0] - p3[0]);
    }
}
