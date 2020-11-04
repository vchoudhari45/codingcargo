package com.vc.hard;

import java.util.*;

class ErectTheFence {
    public int[][] outerTrees(int[][] points) {
        if(points.length <= 1) return points;

        final int[] p = bottomLeft(points);
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] q, int[] r) {
                int pq_qr = crossProduct(p, q, r);
                int pr_rq = crossProduct(p, r, q);
                int diff = Integer.compare(pq_qr, pr_rq);
                if(diff == 0) return Integer.compare(distance(p, q), distance(p, r));
                else return diff;
            }
        });

        //When you come back to complete the loop, points which are closer to starting point should come first
        int i = points.length - 1;
        while(i >= 0 && crossProduct(p, points[i], points[points.length - 1]) == 0) i--;

        int lo = i + 1;
        int hi = points.length - 1;
        while(lo < hi) {
            int[] temp = points[lo];
            points[lo] = points[hi];
            points[hi] = temp;
            lo++;
            hi--;
        }

        Stack<int[]> st = new Stack<>();
        st.push(points[0]);
        st.push(points[1]);
        for(int j = 2; j < points.length; j++) {
            int[] top = st.pop();
            while(crossProduct(st.peek(), top, points[j]) > 0) top = st.pop();
            st.push(top);
            st.push(points[j]);
        }
        return st.toArray(new int[st.size()][]);
    }

    private int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private int crossProduct(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    private int[] bottomLeft(int[][] points) {
        int[] res = points[0];
        for(int i = 1; i < points.length; i++) {
            if(res[1] > points[i][1]) {
                res = points[i];
            }
        }
        return res;
    }
}