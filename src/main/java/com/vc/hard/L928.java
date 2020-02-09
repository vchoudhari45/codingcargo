package com.vc.hard;

import java.util.*;

class L928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        HashSet<Integer> malware = new HashSet<>();
        for(int i: initial) malware.add(i);


        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 1) {
                    List<Integer> toList = map.getOrDefault(i, new ArrayList<Integer>());
                    toList.add(j);
                    map.put(i, toList);
                }
            }
        }
        //System.out.println(map);

        int maxSpread = -1, maxSpreadNode = 0;
        for(int n: initial) {
            HashSet<Integer> visited = new HashSet<>();
            visited.add(n);
            int spread = 0;
            List<Integer> list = map.getOrDefault(n, new ArrayList<Integer>());
            for(Integer l: list) {
                int res = solve(l, map, visited, malware);
                if(res > 0) spread += res;
            }
            if(spread > maxSpread) {
                maxSpread = spread;
                maxSpreadNode = n;
            }
            else if(spread == maxSpread && maxSpreadNode > n) {
                maxSpreadNode = n;
            }
        }
        return maxSpreadNode;
    }

    private int solve(int node, HashMap<Integer, List<Integer>> map,
                      HashSet<Integer> visited, HashSet<Integer> malware) {
        if(visited.contains(node)) return 0;
        if(malware.contains(node)) return -1;

        int res = 1;
        visited.add(node);
        List<Integer> list = map.getOrDefault(node, new ArrayList<Integer>());
        for(Integer l: list) {
            int subRes = solve(l, map, visited, malware);
            if(subRes < 0) {
                malware.add(l);
                return -1;
            }
            res += subRes;
        }
        return res;
    }
}