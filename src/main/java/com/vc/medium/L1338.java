package com.vc.medium;

import java.util.*;

class L1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return Integer.compare(y, x);
            }
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            pq.offer(entry.getValue());

        int total = arr.length;
        int required = total / 2;
        int count = 0;
        while(total > required) {
            total -= pq.poll();
            count++;
        }
        return count;
    }
}
