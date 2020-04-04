package com.vc.medium;

class L959 {
    public int regionsBySlashes(String[] grid) {
        /*
            Represent each square as 3 * 3 matrix
            [" /"]
            ["/ "]

            one represent a line and then problem reduces to find number of island
            [

             1st Col    2nd Col
              0 0 0      0 0 1
              0 0 0      0 1 0   1st Row
              0 0 0      1 0 0

              0 0 1      0 0 0
              0 1 0      0 0 0   2nd Row
              1 0 0      0 0 0
            ]
        */

        if(grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length();

        int[][] matrix = new int[3 * n][3 * m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                }
                else if(grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        // for(int i = 0; i < matrix.length; i++) {
        //     for(int j = 0; j < matrix[0].length; j++) {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        return distinctIsland(matrix);
    }

    private int distinctIsland(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    count++;
                    dfs(i, j, matrix);
                }
            }
        }
        return count;
    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void dfs(int row, int col, int[][] matrix) {
        if(matrix[row][col] == 1) return;

        matrix[row][col] = 1;
        for(int[] dir: dirs) {
            int rowNew = dir[0] + row;
            int colNew = dir[1] + col;
            if(rowNew >= 0 && rowNew < matrix.length && colNew >= 0 && colNew < matrix[0].length) {
                dfs(rowNew, colNew, matrix);
            }
        }
    }
}
