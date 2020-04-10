package com.vc.easy;

class L463 {
    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                for(int[] dir: dirs) {
                    int xNew = i + dir[0];
                    int yNew = j + dir[1];
                    if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                        if(grid[xNew][yNew] == 0) perimeter += 1;
                    }
                    else perimeter += 1;
                }
            }
        }
        return perimeter;
    }
}
