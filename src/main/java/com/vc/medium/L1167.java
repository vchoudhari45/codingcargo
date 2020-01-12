package com.vc.medium;

import java.util.*;

class L1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer stick: sticks) pq.offer(stick);

        int sum = 0;
        while(pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }
        return sum;
    }
}
