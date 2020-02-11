package com.vc.hard;

import java.util.*;

/**
 *  Basically, it uses dfs to travel through the graph to find if current vertex u, can travel back to u or previous vertex
 *  lowest[u] records the lowest vertex u can reach
 *  discovered[u] records the time when u was discovered
 **/
class L1192 {
    int[] discovered, lowest;
    int times = 0; // time when discover each vertex
    HashMap<Integer, List<Integer>> graph;
    List<List<Integer>> res;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        discovered = new int[n];
        lowest = new int[n];
        Arrays.fill(discovered, -1);
        res = new ArrayList<>();

        graph = new HashMap<>();
        for(List<Integer> connection: connections) {
            int from = connection.get(0);
            int to = connection.get(1);

            List<Integer> fromList = graph.getOrDefault(from, new ArrayList<Integer>());
            List<Integer> toList = graph.getOrDefault(to, new ArrayList<Integer>());

            fromList.add(to);
            toList.add(from);

            graph.put(from, fromList);
            graph.put(to, toList);
        }

        //System.out.println(graph);
        for(int i = 0; i < n; i++) {
            if(discovered[i] == -1) {
                dfs(i, i);
            }
        }
        return res;
    }

    private void dfs(int current, int parent) {
        discovered[current] = lowest[current] = times++;

        if(graph.containsKey(current)) {
            for(Integer child: graph.get(current)) {
                if(child == parent) continue; // if parent vertex, that means edge is in cycle

                if(discovered[child] == -1) {
                    dfs(child, current);
                    lowest[current] = Math.min(lowest[current], lowest[child]);
                    if(lowest[child] > discovered[current]) {
                        //child node is not a part of any cycle otherwise
                        //lowest node it could reach was at least current
                        res.add(Arrays.asList(current, child));
                    }
                }
                else {
                    // if child is already discovered and is not parent of current, update lowest[current]
                    lowest[current] = Math.min(lowest[current], lowest[child]);
                }
            }
        }
    }
}