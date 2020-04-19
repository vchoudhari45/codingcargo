package com.vc.medium;

class L323 {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];

        for(int i = 0; i < parent.length; i++) parent[i] = i;

        int components = n;
        for(int[] edge: edges) {
            int fromParent = find(parent, edge[0]);
            int toParent = find(parent, edge[1]);
            if(fromParent == toParent) continue;
            parent[fromParent] = toParent;
            components--;
        }

        return components;
    }

    private int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }
}