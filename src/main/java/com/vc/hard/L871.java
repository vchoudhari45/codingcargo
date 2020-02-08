package com.vc.hard;

import java.util.Collections;
import java.util.PriorityQueue;

class L871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int pos = startFuel;
        int index = 0;
        int refills = 0;
        while(pos < target) {
            while(index < stations.length && pos >= stations[index][0]) {
                pq.offer(stations[index][1]);
                index++;
            }
            if(pq.isEmpty()) return -1;
            pos += pq.poll();
            refills++;
        }
        return refills;
    }
}

