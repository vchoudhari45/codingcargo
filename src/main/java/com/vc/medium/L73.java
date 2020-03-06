package com.vc.medium;

class L73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rows[i] > 0 || cols[j] > 0) matrix[i][j] = 0;
            }
        }
    }
}
