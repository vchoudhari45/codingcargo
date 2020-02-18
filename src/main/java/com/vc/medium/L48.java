package com.vc.medium;

class L48 {
    public void rotate(int[][] matrix) {
        //For Clockwise rotation Reverse Rows
        //1 2 3     7 8 9     7 4 1
        //4 5 6  => 4 5 6  => 8 5 2
        //7 8 9     1 2 3     9 6 3
        int n = matrix.length, i = 0, j = n - 1;
        while(i < j) {
            for(int col = 0; col < n; col++) swap(i, col, j, col, matrix);
            i++;
            j--;
        }

        //For AnticlockWise just reverse the columns
        //1 2 3     3 2 1     3 6 9
        //4 5 6  => 6 5 4  => 2 5 8
        //7 8 9     9 8 7     1 4 7
        // while(i < j) {
        //     for(int row = 0; row < n; row++) swap(row, i, row, j, matrix);
        //     i++;
        //     j--;
        // }

        for(int k = 0; k < n; k++) {
            for(int l = k + 1; l < n; l++) {
                swap(k, l, l, k, matrix);
            }
        }
    }

    private void swap(int fromRow, int fromCol, int toRow, int toCol, int[][] matrix) {
        int temp = matrix[fromRow][fromCol];
        matrix[fromRow][fromCol] = matrix[toRow][toCol];
        matrix[toRow][toCol] = temp;
    }
}