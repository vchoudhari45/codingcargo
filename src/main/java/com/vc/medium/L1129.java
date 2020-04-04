package com.vc.medium;

import java.util.*;

class L1129 {

    private HashMap<Integer, HashSet<Integer>> redMap = new HashMap<>();
    private HashMap<Integer, HashSet<Integer>> blueMap = new HashMap<>();
    private final int RED = 1, BLUE = -1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        for(int[] redEdge: redEdges) {
            int fromRed = redEdge[0], toRed = redEdge[1];
            HashSet<Integer> set = redMap.getOrDefault(fromRed, new HashSet<Integer>());
            set.add(toRed);
            redMap.put(fromRed, set);
        }

        for(int[] blueEdge: blueEdges) {
            int fromBlue = blueEdge[0], toBlue = blueEdge[1];
            HashSet<Integer> set = blueMap.getOrDefault(fromBlue, new HashSet<Integer>());
            set.add(toBlue);
            blueMap.put(fromBlue, set);
        }

        //System.out.println(redMap);
        //System.out.println(blueMap);

        int level = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        q.offer(new int[]{0, RED});
        q.offer(new int[]{0, BLUE});
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] element = q.poll();

                if(res[element[0]] > level) res[element[0]] = level;

                if(visited.contains(element[0]+" "+element[1])) continue;

                visited.add(element[0]+" "+element[1]);
                if(element[1] == RED && redMap.containsKey(element[0])) {
                    for(int nei: redMap.get(element[0])) {
                        q.offer(new int[]{nei, BLUE});
                    }
                }
                else if(element[1] == BLUE && blueMap.containsKey(element[0])) {
                    for(int nei: blueMap.get(element[0])) {
                        q.offer(new int[]{nei, RED});
                    }
                }
            }
            level++;
        }
        for(int i = 0; i < res.length; i++) {
            if(res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }
}
