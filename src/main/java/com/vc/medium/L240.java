package com.vc.medium;

class L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;

        int row = 0;
        int col = c - 1;
        while(row < r && col >= 0) {
            if(target > matrix[row][col]) row++;
            else if(target < matrix[row][col]) col--;
            else return true;
        }
        return false;
    }
}
