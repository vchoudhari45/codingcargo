package com.vc.easy;

import java.util.*;

class L1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 1; i <= N; i++) map.put(i, new HashSet<Integer>());

        for(int[] path: paths) {
            int from = path[0];
            int to = path[1];

            Set<Integer> fromSet = map.getOrDefault(from, new HashSet<>());
            Set<Integer> toSet = map.getOrDefault(to, new HashSet<>());

            fromSet.add(to);
            toSet.add(from);

            map.put(from, fromSet);
            map.put(to, toSet);
        }

        //System.out.println(map);
        int[] res = new int[N];

        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            boolean[] colorTaken = new boolean[5];

            //Mark any color used by neighbour
            for(int nei: entry.getValue()) colorTaken[res[nei - 1]] = true;

            //Choose the color which is not used
            for(int i = 1; i < colorTaken.length; i++) {
                if(!colorTaken[i]) {
                    res[entry.getKey() - 1] = i;
                    break;
                }
            }
        }
        return res;
    }
}
