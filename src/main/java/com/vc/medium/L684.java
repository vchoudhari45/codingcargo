package com.vc.medium;

class L684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            int fromParent = find(from, parent);
            int toParent = find(to, parent);

            if(fromParent == toParent) return edge;
            parent[fromParent] = toParent;
        }
        return new int[0];
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        else return find(parent[x], parent);
    }
}
