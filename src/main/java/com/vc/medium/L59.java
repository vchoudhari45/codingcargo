package com.vc.medium;

class L59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1, rowstart = 0, colstart = 0, rowend = n - 1, colend = n - 1;

        int i = 0;
        while(rowstart <= rowend && colstart <= colend) {

            i = colstart;
            while(i <= colend) {
                res[rowstart][i++] = index++;
            }
            rowstart++;

            i = rowstart;
            while(i <= rowend) {
                res[i++][colend] = index++;
            }
            colend--;

            i = colend;
            while(i >= colstart) {
                res[rowend][i--] = index++;
            }
            rowend--;

            i = rowend;
            while(i >= rowstart) {
                res[i--][colstart] = index++;
            }
            colstart++;
        }
        return res;
    }
}