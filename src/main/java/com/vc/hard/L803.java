package com.vc.hard;

class L803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        //Mark all hits
        for(int[] hit: hits) {
            int hx = hit[0], hy = hit[1];
            grid[hx][hy]--;
        }

        //Mark All Safe
        for(int col = 0; col < grid[0].length; col++) {
            if(grid[0][col] == 1) dfs(grid, 0, col);
        }

        int[] res = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; i--) {
            int hx = hits[i][0], hy = hits[i][1];
            grid[hx][hy]++;
            if(grid[hx][hy] == 1 && isConnected(grid, hx, hy)) {
                res[i] = dfs(grid, hx, hy) - 1;
            }
        }
        return res;
    }

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean isConnected(int[][] grid, int x, int y) {
        if(x == 0) return true;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                    && grid[xNew][yNew] == 2) return true;
        }
        return false;
    }

    private int dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        int res = 1;
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                    && grid[xNew][yNew] == 1) {
                res += dfs(grid, xNew, yNew);
            }
        }
        return res;
    }
}
