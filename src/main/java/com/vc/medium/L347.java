package com.vc.medium;

import java.util.*;

class L347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(y[0], x[0]);
            }
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        List<Integer> res = new ArrayList<>();
        while(k-- > 0) res.add(pq.poll()[1]);
        return res;
    }
}
