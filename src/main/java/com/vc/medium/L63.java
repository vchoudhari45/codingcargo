package com.vc.medium;

class L63 {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) grid[i][j] = 1;
                else if(i == 0) {
                    grid[i][j] = grid[i][j - 1];
                }
                else if(j == 0) {
                    grid[i][j] = grid[i - 1][j];
                }
                else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.format("%3s", grid[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        return grid[n - 1][m - 1];
    }
}
