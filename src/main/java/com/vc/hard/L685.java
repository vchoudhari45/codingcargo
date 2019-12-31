package com.vc.hard;

class L685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodes = edges.length + 1;

        int[] parentArr = new int[nodes];
        for(int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
        }

        int count = 0;
        int[] res = new int[2];
        //Traverse from left to right
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            //parentArr[child] = child <- Meaning this child has more than two parents
            //find(parent) == child <- Meaning there is cycle
            if(parentArr[child] != child || find(parent, parentArr) == child) {
                res = edges[i];
                count++;
            }
            else {
                parentArr[child] = parent;
            }
        }

        if(count == 1) return res;

        for(int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
        }
        //Traverse from right to left
        for(int i = edges.length - 1; i >= 0; i--) {
            int parent = edges[i][0];
            int child = edges[i][1];

            if(parentArr[child] != child || find(parent, parentArr) == child) {
                res = edges[i];
            }
            else {
                parentArr[child] = parent;
            }
        }
        return res;
    }

    private int find(int parent, int[] parentArr) {
        if(parentArr[parent] == parent) return parent;
        else return find(parentArr[parent], parentArr);
    }
}
