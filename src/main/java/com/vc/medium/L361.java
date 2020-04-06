package com.vc.medium;

class L361 {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        int row = 0, max = 0;
        int[] cols = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'W') continue;
                if(i == 0 || grid[i - 1][j] == 'W') {
                    //Calculate fresh for this column as we have wall before this
                    cols[j] = calculateEnemyInCol(grid, i, j);
                }
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = calculateEnemyInRow(grid, i, j);
                }
                if(grid[i][j] == '0') max = Math.max(max, row + cols[j]);
                //System.out.println("For row: "+i+" Col: "+j+" rowCount: "+row+" colCount: "+cols[j]+" max: "+max);
            }
        }
        return max;
    }

    private int calculateEnemyInCol(char[][] grid, int row, int col) {
        int num = 0;
        while(row < grid.length && grid[row][col] != 'W') {
            if(grid[row][col] == 'E') num++;
            row++;
        }
        return num;
    }

    private int calculateEnemyInRow(char[][] grid, int row, int col) {
        int num = 0;
        while(col < grid[0].length && grid[row][col] != 'W') {
            if(grid[row][col] == 'E') num++;
            col++;
        }
        return num;
    }
}