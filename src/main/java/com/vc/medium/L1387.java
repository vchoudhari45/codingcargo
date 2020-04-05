package com.vc.medium;

import java.util.*;

class L1387 {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        map.put(1, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2) {
                int cmp = Integer.compare(e2[0], e1[0]);
                if(cmp == 0) return Integer.compare(e2[1], e1[1]);
                return cmp;
            }
        });

        for(int i = lo; i <= hi; i++) {
            int res = getPower(i);
            pq.offer(new int[]{res, i});
            if(pq.size() > k) pq.poll();
        }

        return pq.poll()[1];
    }

    private int getPower(int n) {
        if(map.containsKey(n)) return map.get(n);

        int res = n % 2 == 0 ? 1 + getPower(n / 2) : 1 + getPower(3 * n + 1);

        map.put(n, res);

        return res;
    }
}
