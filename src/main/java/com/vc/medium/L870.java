package com.vc.medium;

import java.util.*;

class L870 {
    public int[] advantageCount(int[] A, int[] B) {
        /**
             [12,24,8,32]
             [1,10,4,11]
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[0], y[0]);
            }
        });

        for(int i = 0; i < B.length; i++) {
            pq.offer(new int[]{B[i], i});
        }

        while(!pq.isEmpty()) {
            int[] e = pq.poll();
            Integer nge = map.higherKey(e[0]);
            if(nge != null) {
                A[e[1]] = nge;
                map.put(nge, map.getOrDefault(nge, 0) - 1);
                if(map.get(nge) <= 0) map.remove(nge);
            }
            else {
                int small = map.firstKey();
                A[e[1]] = small;
                map.put(small, map.getOrDefault(small, 0) - 1);
                if(map.get(small) <= 0) map.remove(small);
            }
        }
        return A;
    }
}
