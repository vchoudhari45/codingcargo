package com.vc.medium;

class L1219 {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;

        int max = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) {
                    int res = solve(i, j, grid, visited);
                    //System.out.println("max at i: "+i+" j: "+j+" is: "+res);
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private int solve(int x, int y, int[][] grid, boolean[][] visited) {
        if(visited[x][y]) return 0;

        int res = grid[x][y];
        int rMax = 0;
        visited[x][y] = true;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length && grid[xNew][yNew] > 0) {
                rMax = Math.max(rMax, solve(xNew, yNew, grid, visited));
            }
        }
        visited[x][y] = false;

        return res + rMax;
    }
}