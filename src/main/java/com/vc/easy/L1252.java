package com.vc.easy;

class L1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];

        for(int[] indice: indices) {
            row[indice[0]]++;
            col[indice[1]]++;
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((row[i] + col[j]) % 2 != 0) count++;
            }
        }
        return count;
    }
}
