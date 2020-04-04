package com.vc.medium;

import java.util.LinkedList;
import java.util.Queue;

class L1162 {

    private int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        //Add all land cell into the Queue
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0], y = point[1];
            for(int[] dir: dirs) {
                int xNew = x + dir[0];
                int yNew = y + dir[1];
                if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m) {
                    if(grid[xNew][yNew] > grid[x][y] + 1) {
                        grid[xNew][yNew] = grid[x][y] + 1;
                        q.offer(new int[]{xNew, yNew});
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) max = Math.max(max, grid[i][j]);
        }
        return max == Integer.MAX_VALUE || max == 0 ? -1 : max;
    }
}
