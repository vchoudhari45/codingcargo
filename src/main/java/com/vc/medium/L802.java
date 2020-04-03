package com.vc.medium;

import java.util.ArrayList;
import java.util.List;

class L802 {
    private static final int NOT_STARTED = 0, PROCESSING = 1, PROCESSED = 2;

    //Detect a cycle from each node, if cycle exist from that node, it is not safe node
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dfs(i, state, graph)) res.add(i);
        }
        return res;
    }

    private boolean dfs(int currentNode, int[] state, int[][] graph) {
        if(state[currentNode] != NOT_STARTED) return state[currentNode] == PROCESSED;

        state[currentNode] = PROCESSING;
        for(int child: graph[currentNode]) {
            if(!dfs(child, state, graph)) return false;
        }
        state[currentNode] = PROCESSED;

        return true;
    }

}