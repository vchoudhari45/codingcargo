package com.vc.medium;

class L1267 {
    public int countServers(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) res++;
            }
        }
        return res;
    }
}
