package com.vc.easy;

class L766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return true;

        int n = matrix.length;
        int m = matrix[0].length;

        for(int col = 0; col < m; col++) {
            int row = 0;
            int colInner = col;
            int element = matrix[row][colInner];
            while(row < n && colInner < m) {
                if(element != matrix[row][colInner]) return false;
                row++;
                colInner++;
            }
        }

        for(int row = 1; row < n; row++) {
            int col = 0;
            int rowInner = row;
            int element = matrix[rowInner][col];
            while(rowInner < n && col < m) {
                if(element != matrix[rowInner][col]) return false;
                rowInner++;
                col++;
            }
        }

        return true;
    }
}
