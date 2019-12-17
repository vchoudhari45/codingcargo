package com.vc.hard;

class L329 {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;

        int[][] cache = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max = Math.max(max, 1 + solve(matrix, cache, i, j));
            }
        }
        return max;
    }

    private int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    private int solve(int[][] matrix, int[][] cache, int row, int col) {
        if(cache[row][col] > 0) return cache[row][col];
        int max = 0;
        for(int[] dir: dirs) {
            int xNew = row + dir[0];
            int yNew = col + dir[1];
            if(xNew >= 0 && xNew < matrix.length && yNew >= 0 && yNew < matrix[0].length
                    && matrix[row][col] > matrix[xNew][yNew]) {
                max = Math.max(max, 1 + solve(matrix, cache, xNew, yNew));
            }
        }
        cache[row][col] = max;
        return max;
    }
}
