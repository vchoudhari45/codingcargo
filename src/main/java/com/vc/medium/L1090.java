package com.vc.medium;

import java.util.*;

class L1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        HashMap<Integer, Integer> used = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p, int[] q) {
                return Integer.compare(q[1], p[1]);
            }
        });

        for(int i = 0; i < values.length; i++) {
            int value = values[i];
            int label = labels[i];
            pq.offer(new int[]{label, value});
        }

        int n = 0;
        int sum = 0;
        while(!pq.isEmpty() && n < num_wanted) {
            int[] e = pq.poll();
            int label = e[0];
            int value = e[1];
            if(used.containsKey(label) && used.get(label) == use_limit) continue;
            //System.out.println("label: "+label+" value: "+value);
            sum += value;
            n++;
            used.put(label, used.getOrDefault(label, 0) + 1);
        }
        return sum;
    }
}
