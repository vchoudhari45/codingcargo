package com.vc.hard;

class DungeonGame {
    public int calculateMinimumHP(int[][] arr) {
        if(arr == null || arr.length == 0) return 0;

        int m = arr.length;
        int n = arr[0].length;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) {
                    arr[i][j] = Math.min(0, arr[i][j]);
                }
                else if(i == m - 1) {
                    arr[i][j] = Math.min(0, arr[i][j] + arr[i][j + 1]);
                }
                else if(j == n - 1) {
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