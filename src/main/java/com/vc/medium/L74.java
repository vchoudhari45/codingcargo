package com.vc.medium;

class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int n = matrix.length, m = matrix[0].length;

        if(m == 0) return false;

        int row = 0, col = m - 1;
        while(col >= 0 && row < n) {
            if(matrix[row][col] > target) col--;
            else if(matrix[row][col] < target) row++;
            else return true;
        }
        return false;
    }
}
