package com.vc.hard;

import java.util.*;

class L675 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0) return 0;

        int n = forest.size();
        int m = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(forest.get(i).get(j) >= 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] from = new int[2];
        int totalSteps = 0;
        while(!pq.isEmpty()) {
            int[] to = pq.poll();
            int steps = minStep(from, to, forest, n, m);
            if(steps < 0) return -1;
            totalSteps += steps;

            from = to;
        }
        return totalSteps;
    }

    private int minStep(int[] from, int[] to, List<List<Integer>> forest, int row, int col) {
        int step = 0;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        q.add(from);
        visited[from[0]][from[1]] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] current = q.poll();
                if(current[0] == to[0] && current[1] == to[1]) return step;

                for(int[] d: dirs) {
                    int newRow = d[0] + current[0];
                    int newCol = d[1] + current[1];
                    if(newRow < 0 || newRow >= row || newCol < 0
                            || newCol >= col || forest.get(newRow).get(newCol) == 0
                            || visited[newRow][newCol]) continue;
                    q.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
            step++;
        }
        return -1;
    }
}