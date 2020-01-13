package com.vc.medium;

import java.util.*;

class L1245 {
    private int diameter = 0;

    public int treeDiameter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            List<Integer> listFrom = map.getOrDefault(from, new ArrayList<Integer>());
            listFrom.add(to);
            map.put(from, listFrom);

            List<Integer> listTo = map.getOrDefault(to, new ArrayList<Integer>());
            listTo.add(from);
            map.put(to, listTo);
        }
        //System.out.println(map);

        dfs(0, -1, map);
        return diameter;
    }

    private int dfs(int current, int parent, HashMap<Integer, List<Integer>> map) {
        int maxDepth1 = 0, maxDepth2 = 0;
        if(!map.containsKey(current)) return 0;
        for(Integer child: map.get(current)) {
            if(child != parent) {
                int depth = dfs(child, current, map);
                if(depth > maxDepth1) {
                    maxDepth2 = maxDepth1;
                    maxDepth1 = depth;
                }
                else if(depth > maxDepth2) {
                    maxDepth2 = depth;
                }
                diameter = Math.max(diameter, maxDepth1 + maxDepth2);
            }
        }
        return maxDepth1 + 1;
    }
}
