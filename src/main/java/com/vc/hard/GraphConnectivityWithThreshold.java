package com.vc.hard;

import java.util.ArrayList;
import java.util.List;

class GraphConnectivityWithThreshold {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        if(queries == null) return new ArrayList<>();

        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int i = threshold + 1; i <= n; i++) {
            for(int j = i; j <= n; j+=i) {
                int iParent = find(i, parent);
                int jParent = find(j, parent);
                parent[iParent] = jParent;
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            int xParent = find(query[0], parent);
            int yParent = find(query[1], parent);
            res.add(xParent == yParent);
        }
        return res;
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }
}