package com.vc.medium;

import java.util.*;

class L1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            List<Integer> list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
        }

        return dfs(source, destination, map, new HashSet<Integer>());
    }

    private boolean dfs(int current, int target, HashMap<Integer, List<Integer>> map,
                        HashSet<Integer> visited) {
        if(!map.containsKey(current)) return current == target;

        if(visited.contains(current)) return false;

        visited.add(current);
        for(int child : map.get(current)) if(!dfs(child, target, map, visited)) return false;
        visited.remove(current);

        return true;
    }
}
