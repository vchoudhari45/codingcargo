package com.vc.medium;

import java.util.*;

class L469 {
    public boolean isConvex(List<List<Integer>> points) {
        boolean isPositive = false, isNegative = false;
        for(int i = 0; i < points.size(); i++) {
            List<Integer> A = points.get(i);
            List<Integer> B = points.get((i + 1) % points.size());
            List<Integer> C = points.get((i + 2) % points.size());

            int crossProduct = crossProduct(A, B, C);
            if(crossProduct < 0) isNegative = true;
            else if(crossProduct > 0) isPositive = true;

            if(isNegative && isPositive) return false;
        }
        return true;
    }

    private int crossProduct(List<Integer> A, List<Integer> B, List<Integer> C) {
        int ax = A.get(0), ay = A.get(1);
        int bx = B.get(0), by = B.get(1);
        int cx = C.get(0), cy = C.get(1);

        int ABx = ax - bx;
        int ABy = ay - by;
        int ACx = ax - cx;
        int ACy = ay - cy;

        return ABx * ACy - ABy * ACx;
    }
}
