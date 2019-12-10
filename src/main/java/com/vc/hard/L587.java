package com.vc.hard;

import java.util.*;

class L587 {
    public int[][] outerTrees(int[][] arr) {
        int n = arr.length;
        if(n == 0) return new int[0][0];

        Set<int[]> res = new HashSet<>();

        //find left most point
        int[] start = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i][0] < start[0]) {
                start = arr[i];
            }
        }

        int[] current = start;
        res.add(current);
        List<int[]> colinear = new ArrayList<int[]>();
        while(true) {
            int[] nextTarget = arr[0]; //Assumption
            for(int i = 1; i < n; i++) {

                if(arr[i] == current) continue;

                //try to see if arr[i] is on the left side of the current -> nextTarget(Assumption)
                //if so nextTarget = arr[i]
                //else nextTarget continues to be the same
                int crossProduct = crossProduct(current, nextTarget, arr[i]);

                // System.out.println("Finding crossProduct for current: "+print(current)
                //                    +" nextTarget: "+print(nextTarget)
                //                    +" candidate: " +print(arr[i])
                //                    +" crossProduct: "+crossProduct);

                if(crossProduct == 0) {
                    int distance = distance(current, nextTarget, arr[i]);
                    if(distance < 0) {
                        colinear.add(nextTarget);
                        nextTarget = arr[i];
                    }
                    else colinear.add(arr[i]);
                }
                else if(crossProduct > 0) {
                    nextTarget = arr[i];
                    colinear = new ArrayList<>();
                }
            }

            res.add(nextTarget);

            //Add all the colinear points
            for(int[] e: colinear) res.add(e);

            if(nextTarget == start) break;
            current = nextTarget;
        }

        int[][] r = new int[res.size()][2];
        int index = 0;
        for(int[] e: res) r[index++] = e;

        return r;
    }

    private String print(int[] arr) {
        return "("+arr[0]+", "+arr[1]+")";
    }

    //if +ve c is closer, -ve b is closer else both are at same distance from a
    private int distance(int[] a, int[] b, int[] c) {
        int ax = a[0], ay = a[1];
        int bx = b[0], by = b[1];
        int cx = c[0], cy = c[1];

        int ab = (bx - ax) * (bx - ax) + (by - ay) * (by - ay);
        int ac = (cx - ax) * (cx - ax) + (cy - ay) * (cy - ay);

        return ab - ac;
    }

    //By right hand thumb rule, if c is on the left side of ab result is +ve
    //if c is on the right side of ab result is -ve
    //else a, b & c are colinear points
    private int crossProduct(int[] a, int[] b, int[] c) {
        int abx = a[0] - b[0];
        int aby = a[1] - b[1];

        int acx = a[0] - c[0];
        int acy = a[1] - c[1];

        //cross product so
        return abx * acy - aby * acx;
    }
}