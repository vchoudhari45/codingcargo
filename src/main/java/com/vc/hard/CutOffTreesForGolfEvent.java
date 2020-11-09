package com.vc.hard;

import java.util.*;

class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null) return 0;

        int n = forest.size();
        if(n == 0) return 0;
        int m = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2) {
                return Integer.compare(e1[2], e2[2]);
            }
        });

        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if(val >= 1) {
                    pq.offer(new int[]{i, j, val});
                }
            }
        }

        int res = 0;
        int[] prev = new int[]{0, 0, forest.get(0).get(0)};
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int distance = getDistance(forest, prev, current, n, m);
            if(distance == -1) return -1;
            res += distance;
            prev = current;
            forest.get(current[0]).set(current[1], 1);
        }
        return res;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private int getDistance(List<List<Integer>> forest,
                            int[] source, int[] target, int totalRow, int totalCol) {
        //Hadlock's Algorithm
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[]{source[0], source[1], 0});
        HashSet<String> visited = new HashSet<>();

        /**
             Hadlock Algorithm works on detour,
             if move takes us away from target, then we increment detour
             else we don't increment detour

             Final distance from source to target will be
             distance = (target[0] - source[0]) + (target[1] - source[1]) + 2 * detour;

             2 * detour because we have to cover detour two times,
             Once when we go away from target
             And then back to target again.
         */
        while(!q.isEmpty()) {
            int[] e = q.pollFirst();

            if(e[0] == target[0] && e[1] == target[1]) {
                return Math.abs(target[0] - source[0]) + Math.abs(target[1] - source[1]) + 2 * e[2];
            }
            String key = e[0] + " " + e[1];

            if(visited.contains(key)) continue;

            visited.add(key);
            for(int[] dir: dirs) {
                int eNewX = e[0] + dir[0];
                int eNewY = e[1] + dir[1];
                if(eNewX >= 0 && eNewX < totalRow && eNewY >= 0 && eNewY < totalCol && forest.get(eNewX).get(eNewY) != 0) {
                    boolean isDetour = false;
                    if(e[0] <= target[0] && dir[0] == -1) {
                        isDetour = true;
                    }
                    else if(e[0] >= target[0] && dir[0] == 1) {
                        isDetour = true;
                    }
                    else if(e[1] <= target[1] && dir[1] == -1) {
                        isDetour = true;
                    }
                    else if(e[1] >= target[1] && dir[1] == 1) {
                        isDetour = true;
                    }

                    if(isDetour) q.offerLast(new int[]{eNewX, eNewY, e[2] + 1});
                    else q.offerFirst(new int[]{eNewX, eNewY, e[2]});
                }
            }
        }
        return -1;
    }
}