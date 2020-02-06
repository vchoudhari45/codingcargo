package com.vc.hard;

import java.util.*;

class L1326 {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int cmp = Integer.compare(x[0], y[0]);
                if(cmp == 0) cmp = Integer.compare(y[1], x[1]);
                return cmp;
            }
        });

        for(int i = 0; i < ranges.length; i++) {
            if(ranges[i] == 0) continue;
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            pq.offer(new int[]{start, end});
        }

        int res = 0, end = 0;
        while(!pq.isEmpty()) {
            if(pq.peek()[0] > end) return -1;

            int maxEnd = 0;
            while(!pq.isEmpty() && pq.peek()[0] <= end) {
                maxEnd = Math.max(maxEnd, pq.poll()[1]);
            }
            end = maxEnd;

            res++;
            if(end >= n) return res;
        }
        return end >= n ? res : -1;
    }
}
