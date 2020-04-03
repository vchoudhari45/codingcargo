package com.vc.medium;

import java.util.*;

class L1059 {
    private final static int NOT_STARTED = 0, PROCESSING = 1, PROCESSED = 2;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        int[] states = new int[n];
        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];

            List<Integer> fromList = graph.getOrDefault(from, new ArrayList<>());
            fromList.add(to);
            graph.put(from, fromList);
        }

        return dfs(source, destination, states, graph);
    }

    private boolean dfs(int current, int destination, int[] states, HashMap<Integer, List<Integer>> graph) {
        if(states[current] != NOT_STARTED) return states[current] == PROCESSED;

        if(!graph.containsKey(current)) return current == destination;
        states[current] = PROCESSING;
        for(int child: graph.get(current)) {
            if(!dfs(child, destination, states, graph)) return false;
        }
        states[current] = PROCESSED;
        return true;
    }
}