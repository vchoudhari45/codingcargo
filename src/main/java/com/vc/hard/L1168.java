package com.vc.hard;

import java.util.*;

class L1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] parentArr = new int[n + 1];
        for(int i = 0; i <= n; i++) parentArr[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        for(int i = 0; i < wells.length; i++) pq.offer(new int[]{0, i + 1, wells[i]});

        for(int[] pipe: pipes) pq.offer(pipe);

        int cost = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();

            int from = edge[0], to = edge[1];
            int fromParent = find(from, parentArr);
            int toParent = find(to, parentArr);

            if(fromParent == toParent) continue;

            parentArr[toParent] = fromParent;
            cost += edge[2];
            //System.out.println(edge[0]+" "+edge[1]+" "+edge[2]+" "+cost);
        }
        return cost;
    }

    private int find(int x, int[] parentArr) {
        if(x == parentArr[x]) return x;
        else return parentArr[x] = find(parentArr[x], parentArr);
    }
}
