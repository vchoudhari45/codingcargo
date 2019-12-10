package com.vc.hard;

import java.util.*;

class L1199 {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < blocks.length; i++) {
            pq.add(blocks[i]);
        }
        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(y + split);
        }
        return pq.poll();
    }
}