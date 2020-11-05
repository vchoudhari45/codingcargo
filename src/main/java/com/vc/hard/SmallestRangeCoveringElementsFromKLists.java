package com.vc.hard;

import java.util.*;

class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0) return new int[0];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[2], y[2]);
            }
        });

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{i, 0, val});
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int start = min;
        int end = max;
        int minRange = end - start;
        while(pq.size() == nums.size()) {
            int[] q = pq.poll();
            int row = q[0];
            int col = q[1];
            int val = q[2];

            if(max - val < minRange) {
                minRange = max - val;
                min = val;
                start = min;
                end = max;
            }

            if(col + 1 < nums.get(row).size()) {
                int newVal = nums.get(row).get(col + 1);
                pq.offer(new int[]{row, col + 1, newVal});
                max = Math.max(max, newVal);
            }
        }

        return new int[]{start, end};
    }
}