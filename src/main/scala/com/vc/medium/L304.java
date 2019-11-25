package com.vc.medium;

class NumMatrix {
    int[][] arr;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        if(m == 0) return;
        this.n = matrix[0].length;
        arr = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i + 1][j + 1] = matrix[i][j];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] += arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return arr[row2 + 1][col2 + 1] + arr[row1][col1] - arr[row2 + 1][col1] - arr[row1][col2 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
