package com.vc.hard;

class L174 {
    public int calculateMinimumHP(int[][] arr) {
        /**
             -2  -3   3
             -5  -10  1
             10   30 -5

             -6  -4  -1
             -5  -10 -4
              0   0  -5
         */

        if(arr == null || arr.length == 0) return 0;

        int n = arr.length, m = arr[0].length;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) {
                    arr[i][j] = Math.min(0, arr[i][j]);
                }
                else if(i == n - 1) {
                    arr[i][j] = Math.min(0, arr[i][j] + arr[i][j + 1]);
                }
                else if(j == m - 1) {
                    arr[i][j] = Math.min(0, arr[i][j] + arr[i + 1][j]);
                }
                else {
                    arr[i][j] = Math.min(0, arr[i][j] + Math.max(arr[i + 1][j], arr[i][j + 1]));
                }
            }
        }

        return -arr[0][0] + 1;
    }
}