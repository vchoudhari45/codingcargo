package com.vc.hard;

import java.util.*;

class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] total = new int[m][n];
        int[][] count = new int[m][n];

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int totalBuilding = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    totalBuilding++;
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] visited = new boolean[m][n];

                    q.offer(new int[]{i, j});
                    int level = 0;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int e = 0; e < size; e++) {
                            int[] point = q.poll();

                            int x = point[0];
                            int y = point[1];

                            if(visited[x][y] || grid[x][y] == 2) continue;

                            visited[x][y] = true;
                            for(int[] dir: dirs) {
                                int xNew = x + dir[0];
                                int yNew = y + dir[1];

                                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                                        && grid[xNew][yNew] != 1 && grid[xNew][yNew] != 2) {
                                    q.offer(new int[]{xNew, yNew});
                                }
                            }

                            if(grid[x][y] == 0) {
                                total[x][y] += level;
                                count[x][y]++;
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(count[i][j] == totalBuilding) res = Math.min(res, total[i][j]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}