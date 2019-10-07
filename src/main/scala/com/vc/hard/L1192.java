package com.vc.hard;

import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        int[] disc = new int[n];
        int[] low = new int[n];
        dfs(0, -1, graph, disc, low);
        return res;
    }

    int time = 0;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    private void dfs(int from, int prev, List<Integer> graph[], int[] disc, int[] low) {
        disc[from] = ++time;
        low[from] = time;
        for(int i = 0; i < graph[from].size(); i++) {
            int to = graph[from].get(i);
            if(to ==prev) continue;
            if(disc[to] == 0) {
                dfs(to, from, graph, disc, low);
                low[from] = Math.min(low[from], low[to]);
                if(low[to] > disc[from]) {
                    res.add(Arrays.asList(from, to));
                }
            }
            else {
                low[from] = Math.min(low[from], low[to]);
            }
        }
    }
}
