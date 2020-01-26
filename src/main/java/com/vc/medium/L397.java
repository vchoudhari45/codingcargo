package com.vc.medium;

import java.util.*;

class L397 {
    public int integerReplacement(int n) {
        int res = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long[] x, long[] y) {
                return Long.compare(x[1], y[1]);
            }
        });
        pq.offer(new long[]{n, 0});
        HashSet<Long> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            int size = pq.size();
            for(int i = 0; i < size; i++) {
                long[] e = pq.poll();

                if(e[0] == 1) return (int)e[1];
                if(visited.contains(e[0])) continue;

                visited.add(e[0]);
                if(e[0] % 2 == 0) pq.offer(new long[]{e[0] / 2, e[1] + 1});
                else {
                    pq.offer(new long[]{e[0] + 1, e[1] + 1});
                    pq.offer(new long[]{e[0] - 1, e[1] + 1});
                }
            }
        }
        return -1;
    }
}
