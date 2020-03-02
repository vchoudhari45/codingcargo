package com.vc.medium;

import static java.lang.Math.min;

class L1277 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = min(min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
