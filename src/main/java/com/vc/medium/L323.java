package com.vc.medium;

import java.util.*;

class L323 {
    private int[] parent;

    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];

        for(int i = 0; i < n; i++) parent[i] = i;

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            int fromParent = find(from);
            int toParent = find(to);

            if(fromParent != toParent) {
                union(fromParent, toParent);
            }
        }

        HashSet<Integer> distinct = new HashSet<>();
        for(int i = 0; i < parent.length; i++) {
            parent[i] = find(parent[i]);
            distinct.add(parent[i]);
        }
        return distinct.size();
    }

    private int find(int child) {
        if(parent[child] == child) return child;
        else return find(parent[child]);
    }

    private void union(int from, int to) {
        if(from < to) parent[from] = to;
        else parent[to] = from;
    }
}
