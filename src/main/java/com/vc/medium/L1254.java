package com.vc.medium;

class L1254 {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;

        //0th Row & nth Row
        for(int col = 0; col < m; col++) {
            if(grid[0][col] == 0) {
                eliminate(grid, 0, col);
            }
            if(grid[n - 1][col] == 0) {
                eliminate(grid, n - 1, col);
            }
        }

        //0th Col & mth Col
        for(int row = 0; row < n; row++) {
            if(grid[row][0] == 0) {
                eliminate(grid, row, 0);
            }
            if(grid[row][m - 1] == 0) {
                eliminate(grid, row, m - 1);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    count++;
                    count(grid, i, j);
                }
            }
        }
        return count;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private void count(int[][] grid, int x, int y) {
        if(grid[x][y] != 0) return;

        grid[x][y] = 2;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0
                    && yNew < grid[0].length && grid[xNew][yNew] == 0) {
                count(grid, xNew, yNew);
            }
        }
    }

    private void eliminate(int[][] grid, int x, int y) {
        if(grid[x][y] == 1) return;

        grid[x][y] = 2;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0
                    && yNew < grid[0].length && grid[xNew][yNew] == 0) {
                eliminate(grid, xNew, yNew);
            }
        }
    }
}