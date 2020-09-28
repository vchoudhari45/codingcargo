package com.vc.medium;

class RangeSumQuery2dImmutable {
    private int[][] prefix;
    /**
        Input Array:
            0 1 2
         0  1 2 3
         1  4 5 6
         2  7 8 9

        Prefix Array:
            0  1  2  3
         0  0  0  0  0
         1  0  1  3  6
         2  0  5 12 21
         3  0 12 27 45

         Range Input = r1 = 1, c1 = 1, r2 = 2, c2 = 2

         formula: prefix[r2 + 1][c2 + 1] + prefix[r1][c1] - prefix[r2 + 1][c1] - prefix[r1][c2 + 1]

     */
    public RangeSumQuery2dImmutable(int[][] matrix) {
        if(matrix != null && matrix.length != 0) {
            int n = matrix.length;
            int m = matrix[0].length;
            prefix = new int[n + 1][m + 1];

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] + matrix[i - 1][j - 1] - prefix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        if(prefix == null || prefix.length == 0) return 0;
        else return prefix[r2 + 1][c2 + 1] + prefix[r1][c1] - prefix[r2 + 1][c1] - prefix[r1][c2 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */