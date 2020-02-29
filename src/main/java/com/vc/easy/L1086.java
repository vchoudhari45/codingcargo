package com.vc.easy;

import java.util.*;

class L1086 {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int[] item: items) {
            PriorityQueue<Integer> pq = map.getOrDefault(item[0],
                    new PriorityQueue<>(Collections.reverseOrder()));
            pq.offer(item[1]);
            map.put(item[0], pq);
        }

        int k = 5;
        int[][] res = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            int i = 0;
            int total = 0;
            while(i++ < k) total += pq.poll();
            res[index++] = new int[]{id, total / k};
        }
        return res;
    }
}
