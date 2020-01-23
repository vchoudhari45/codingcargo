package com.vc.medium;

import java.util.*;

class L417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        int n = matrix.length;
        if(n == 0) return res;
        int m = matrix[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, m - 1, atlantic);
        }

        for(int i = 0; i < m; i++) {
            dfs(matrix, 0, i, pacific);
            dfs(matrix, n - 1, i, atlantic);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    res.add(r);
                }
            }
        }
        return res;
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void dfs(int[][] matrix, int x, int y, boolean[][] visited) {
        if(visited[x][y]) return;

        visited[x][y] = true;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < matrix.length
                    && yNew >= 0 && yNew < matrix[0].length
                    && matrix[xNew][yNew] >= matrix[x][y]) {
                dfs(matrix, xNew, yNew, visited);
            }
        }
    }
}
