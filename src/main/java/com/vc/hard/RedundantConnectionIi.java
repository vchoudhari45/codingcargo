package com.vc.hard;

class RedundantConnectionIi {
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

            //If we find multipleParentEdge we don't add it to parentArr
            if(toParent != to) multipleParentEdge = edge;
            //If we find cycleEdge we don't add it to parentArr
            else if(fromParent == toParent) cycleEdge = edge;
            else parentArr[toParent] = fromParent;
        }

        if(multipleParentEdge == null) return cycleEdge;
        if(cycleEdge == null) return multipleParentEdge;

        //Now if we find both that means multipleParentEdge is not part of cycle,
        //So there has to be another edge which will cause cycle and causing multipleParent
        for(int[] edge: edges) {
            if(edge[1] == multipleParentEdge[1]) return edge;
        }
        return multipleParentEdge;  //won't reach here
    }

    private int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x], parent);
    }
}