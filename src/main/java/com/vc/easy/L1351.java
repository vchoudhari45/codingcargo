package com.vc.easy;

class L1351 {
    public int countNegatives(int[][] grid) {
        /**
             [4,  3,  2, -1],
             [3,  2,  1, -1],
             [1,  1, -1, -2],
             [-1,-1, -2, -3]
         */
        int n = grid.length;
        if(n == 0) return 0;

        int m = grid[0].length;
        if(m == 0) return 0;

        int row = 0, col = m - 1;
        int res = 0;
        while(row < n && col >= 0) {
            if(grid[row][col] < 0) {
                res += (n - row);
                col--;
            }
            else {
                row++;
            }
        }
        return res;
    }
}
