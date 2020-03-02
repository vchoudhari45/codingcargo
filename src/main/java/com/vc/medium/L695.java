package com.vc.medium;

class L695 {

    private int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        this.grid = grid;

        int n = grid.length;
        int m = grid[0].length;
        if(m == 0) return 0;

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col) {
        if(grid[row][col] == 0) return 0;

        grid[row][col] = 0;
        int area = 1;
        for(int[] dir: dirs) {
            int xNew = row + dir[0];
            int yNew = col + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                area += dfs(xNew, yNew);
            }
        }
        return area;
    }
}
