package com.vc.medium;

import java.util.*;

class L323 {
    public int countComponents(int n, int[][] edges) {
        int[] parentArr = new int[n];
        for(int i = 0; i < n; i++) parentArr[i] = i;

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            int fromParent = find(from, parentArr);
            int toParent = find(to, parentArr);

            parentArr[toParent] = fromParent;
        }

        //Update parentReference
        for(int i = 0; i < parentArr.length; i++) parentArr[i] = find(i, parentArr);

        HashSet<Integer> components = new HashSet<>();
        for(int i = 0; i < parentArr.length; i++) components.add(parentArr[i]);

        return components.size();
    }

    private int find(int x, int[] parentArr) {
        if(parentArr[x] == x) return x;
        else return parentArr[x] = find(parentArr[x], parentArr);
    }
}