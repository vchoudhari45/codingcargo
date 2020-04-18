package com.vc.medium;

class L547 {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;

        int n = M.length;
        int[] parent = new int[M.length];
        for(int i = 0; i < M.length; i++) parent[i] = i;

        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                if(i != j && M[i][j] == 1) {
                    int fromParent = find(parent, i);
                    int toParent = find(parent, j);

                    if(fromParent == toParent) continue;
                    parent[fromParent] = toParent;
                    n--;
                }
            }
        }
        return n;
    }

    private int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }
}
