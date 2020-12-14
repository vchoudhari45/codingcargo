package com.vc.hard;

class MinimumNumberOfDaysToDisconnectIsland {
    public int minDays(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        if(islandCount(grid) != 1) return 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(islandCount(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        /**
             At most it will take 2 days to disconnect island,
             because you can just disconnect one island on bottom left as below

             Let's say we have:
             1 1 1
             1 1 1
             1 1 1

             Disconnect bottome left island like so:
             1 1 1
             0 1 1
             1 0 1
         */
        return 2;
    }

    private int islandCount(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if(visited[row][col]) return;

        visited[row][col] = true;
        for(int[] dir: dirs) {
            int rowNew = row + dir[0];
            int colNew = col + dir[1];
            if(rowNew >= 0 && rowNew < grid.length && colNew >= 0 && colNew < grid[0].length &&
                    grid[rowNew][colNew] == 1) {
                dfs(grid, visited, rowNew, colNew);
            }
        }
    }
}