package com.vc.medium;

class L1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        /**
         [
             [1,2,3],
             [4,5,6],
             [7,8,9]
         ]

         [
             [0, 0, 0, 0],
             [0, 1, 3, 6],
             [0, 5,12,21],
             [0, 6,21,39]
         ]
         */
        int n = mat.length;
        if(n == 0) return mat;
        int m = mat[0].length;

        int[][] sum = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);
                int r2 = Math.min(n, i + K + 1);
                int c2 = Math.min(m, j + K + 1);

                mat[i][j] = sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
            }
        }
        return mat;
    }
}
