package com.vc.hard;

class L685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] parentArr = new int[n + 1];
        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        int[] cycleEdge = null;
        int[] multipleParentEdge = null;
        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];

            int fromParent = find(from, parentArr);
            int toParent = find(to, parentArr);

            if(toParent != to) multipleParentEdge = edge;
            else if(fromParent == toParent) cycleEdge = edge;
            else parentArr[toParent] = fromParent;
        }

        if(multipleParentEdge == null) return cycleEdge;
        if(cycleEdge == null) return multipleParentEdge;

        //If we find both the issue, choose a edge which is in the cycle
        //And to do that we go over edges once more and find the first edge which cause multipleParent issue
        for(int[] edge: edges) {
            if(edge[1] == multipleParentEdge[1]) return edge;
        }
        return cycleEdge;
    }

    private int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x], parent);
    }
}