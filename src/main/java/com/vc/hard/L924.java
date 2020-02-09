package com.vc.hard;

import java.util.*;

class L924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 1) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }

        int maxSpread = -1, maxSpreadNode = 0;
        for(int n: initial) {
            HashSet<Integer> visited = new HashSet<>();
            int spread = solve(n, visited, map);
            if(maxSpread < spread) {
                maxSpread = spread;
                maxSpreadNode = n;
            }
            else if(maxSpread == spread && maxSpreadNode > n) {
                maxSpreadNode = n;
            }
        }
        return maxSpreadNode;
    }

    private int solve(int node, HashSet<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        if(visited.contains(node)) return 0;

        visited.add(node);
        List<Integer> neighbour = graph.getOrDefault(node, new ArrayList<Integer>());
        int res = 1;
        for(Integer i: neighbour) {
            res += solve(i, visited, graph);
        }
        return res;
    }
}
