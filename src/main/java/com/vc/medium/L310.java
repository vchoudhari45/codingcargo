package com.vc.medium;

import java.util.*;

class L310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] edge: edges) {
            int from = edge[0], to = edge[1];

            Set<Integer> setFrom = map.getOrDefault(from, new HashSet<Integer>());
            setFrom.add(to);

            Set<Integer> setTo = map.getOrDefault(to, new HashSet<Integer>());
            setTo.add(from);

            map.put(from, setFrom);
            map.put(to, setTo);
        }

        List<Integer> leaves = new ArrayList<>();
        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if(entry.getValue().size() == 1) leaves.add(entry.getKey());
        }

        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaf = new ArrayList<>();
            for(Integer leaf: leaves) {
                if(map.containsKey(leaf)) {
                    for(Integer neighbour: map.get(leaf)) {
                        map.get(neighbour).remove(leaf);
                        if(map.get(neighbour).size() == 1) {
                            newLeaf.add(neighbour);
                        }
                    }
                }
            }
            leaves = newLeaf;
        }
        return leaves;
    }
}
