package com.vc.medium;

import java.util.*;

class L1135 {

    public int minimumCost(int N, int[][] connections) {
        int[] parentArr = new int[N + 1];
        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p, int[] q) {
                return Integer.compare(p[2], q[2]);
            }
        });

        for (int[] connection : connections) pq.offer(connection);

        int res = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();

            int from = edge[0];
            int to = edge[1];
            int value = edge[2];

            int fromParent = find(from, parentArr);
            int toParent = find(to, parentArr);

            if(fromParent == toParent) continue;

            parentArr[toParent] = fromParent;
            res += value;
            N--;
        }
        return N == 1 ? res : -1;
    }

    private int find(int from, int[] parentArr) {
        if(parentArr[from] == from) return from;
        return parentArr[from] = find(parentArr[from], parentArr);
    }
}