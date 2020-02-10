package com.vc.hard;

class L980 {
    int count = 0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int empty = 1, sx = 0, sy = 0, ex = 0, ey = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) empty++;
                else if(grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                else if(grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        solve(sx, sy, ex, ey, empty, grid);
        return count;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private void solve(int sx, int sy, int ex, int ey, int empty, int[][] grid) {
        if(grid[sx][sy] == -2) return;
        if(sx == ex && sy == ey && empty == 0) count++;

        grid[sx][sy] = -2;
        for(int[] dir: dirs) {
            int xNew = sx + dir[0];
            int yNew = sy + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                    && grid[xNew][yNew] >= 0) {
                solve(xNew, yNew, ex, ey, empty - 1, grid);
            }
        }
        grid[sx][sy] = 0;
    }
}
