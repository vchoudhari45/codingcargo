package com.vc.medium;

class L130 {
    public void solve(char[][] grid) {
        int n = grid.length;
        if(n == 0) return;
        int m = grid[0].length;

        //0th & nth Row
        for(int col = 0; col < m; col++) {
            if(grid[0][col] == 'O') eliminate(grid, 0, col);
            if(grid[n - 1][col] == 'O') eliminate(grid, n - 1, col);
        }

        //0th & mth Col
        for(int row = 0; row < n; row++) {
            if(grid[row][0] == 'O') eliminate(grid, row, 0);
            if(grid[row][m - 1] == 'O') eliminate(grid, row, m - 1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'O') grid[i][j] = 'X';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'K') grid[i][j] = 'O';
            }
        }
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private void eliminate(char[][] grid, int x, int y) {
        if(grid[x][y] != 'O') return;

        grid[x][y] = 'K';
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0
                    && xNew < grid.length
                    && yNew >= 0
                    && yNew < grid[0].length
                    && grid[xNew][yNew] == 'O') eliminate(grid, xNew, yNew);
        }
    }
}
