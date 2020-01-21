package com.vc.medium;

import java.util.*;

class L934 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;

        int color = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, color++);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) return expand(grid, i, j);
            }
        }
        return 1;
    }

    private int dirs[][] = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    private int expand(int[][] grid, int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p, int[] q) {
                return Integer.compare(p[2], q[2]);
            }
        });

        HashSet<String> visited = new HashSet<>();
        pq.offer(new int[]{x, y, 0});
        while(!pq.isEmpty()) {
            int size = pq.size();
            for(int i = 0; i < size; i++) {
                int[] e = pq.poll();
                if(grid[e[0]][e[1]] == 3) return e[2];

                String key = e[0]+" "+e[1];

                if(visited.contains(key)) continue;

                visited.add(key);
                for(int[] dir: dirs) {
                    int xNew = e[0] + dir[0];
                    int yNew = e[1] + dir[1];
                    if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                        if(grid[xNew][yNew] == 2) {
                            pq.offer(new int[]{xNew, yNew, e[2]});
                        }
                        else if(grid[xNew][yNew] == 0){
                            pq.offer(new int[]{xNew, yNew, e[2] + 1});
                        }
                        else return e[2];
                    }
                }
            }
        }
        return 1;
    }

    private void dfs(int[][] grid, int x, int y, int color) {
        if(grid[x][y] == 1) {
            grid[x][y] = color;
            for(int[] dir: dirs) {
                int xNew = x + dir[0];
                int yNew = y + dir[1];
                if(xNew >= 0 && xNew < grid.length
                        && yNew >= 0 && yNew < grid[0].length && grid[xNew][yNew] == 1) {
                    dfs(grid, xNew, yNew, color);
                }
            }
        }
    }
}
