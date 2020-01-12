package com.vc.medium;

class L1254 {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    boolean res = solve(grid, i, j);
                    //System.out.println("island at ("+i+", "+j+") "+res);
                    count += (res ? 1: 0);
                }
            }
        }
        return count;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private boolean solve(int[][] grid, int x, int y) {
        if(grid[x][y] == 1) return true;

        grid[x][y] = 1;
        boolean[] bdir = new boolean[4];
        for(int i = 0; i < dirs.length; i++) {
            int xNew = x + dirs[i][0];
            int yNew = y + dirs[i][1];

            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                bdir[i] = solve(grid, xNew, yNew);
            }
        }
        return bdir[0] && bdir[1] && bdir[2] && bdir[3];
    }
}
