package com.vc.hard;

import java.util.*;

class L928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        HashSet<Integer> malware = new HashSet<Integer>();
        for(Integer item: initial) {
            malware.add(item);
        }

        int max = -1, ret = -1;
        for(Integer item: initial) {
            int save = 0;
            HashSet<Integer> visited = new HashSet();
            visited.add(item);
            for(int i = 0; i < graph.length; i++) {
                if(i != item && graph[item][i] == 1) {
                    int temp = dfs(i, graph, malware, visited);
                    if(temp < 0) continue;
                    save += temp;
                }
            }
            if(save > max) {
                max = save;
                ret = item;
            }
        }
        return ret;
    }

    private int dfs(int item, int[][] graph, HashSet<Integer> malware, HashSet<Integer> visited) {
        if(visited.contains(item)) return 0;
        if(malware.contains(item)) return -1;

        int save = 1;
        visited.add(item);
        for(int i = 0; i < graph.length; i++) {
            if(i != item && graph[item][i] == 1) {
                int temp = dfs(i, graph, malware, visited);
                if(temp < 0) {
                    malware.add(item);
                    return -1;
                }
                save += temp;
            }
        }
        return save;
    }
}