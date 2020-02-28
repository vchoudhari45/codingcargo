package com.vc.medium;

class L48 {

    private int[][] matrix;
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length, from = 0, to = n - 1;

        /**
             For Clockwise rotation Reverse Rows
             1 2 3     7 8 9     7 4 1
             4 5 6  => 4 5 6  => 8 5 2
             7 8 9     1 2 3     9 6 3

             For Anti ClockWise just reverse the columns
             1 2 3     3 2 1     3 6 9
             4 5 6  => 6 5 4  => 2 5 8
             7 8 9     9 8 7     1 4 7
         */
        while(from < to) {
            for(int col = 0; col < matrix[0].length; col++) swap(from, col, to, col);
            from++;
            to--;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(i, j, j, i);
            }
        }
    }

    private void swap(int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}