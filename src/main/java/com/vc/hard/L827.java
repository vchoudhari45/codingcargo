package com.vc.hard;

import java.util.*;

class L827 {
    public int largestIsland(int[][] grid) {
        //Color each island with different color
        int colorIndex = 2;
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int res = dfs(grid, i, j, colorIndex);
                    max = Math.max(max, res);
                    colorMap.put(colorIndex, res);
                    colorIndex++;
                }
            }
        }

        //Stitch two island with different color
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    int newArea = 1;
                    HashSet<Integer> colors = new HashSet<>();
                    //No island exists with -1;
                    colors.add(i - 1 >= 0 ? grid[i - 1][j]: -1);
                    colors.add(j - 1 >= 0 ? grid[i][j - 1]: -1);
                    colors.add(i + 1 < grid.length ? grid[i + 1][j]: -1);
                    colors.add(j + 1 < grid[0].length ? grid[i][j + 1]: -1);
                    for(Integer color: colors) {
                        newArea += colorMap.getOrDefault(color, 0);
                    }
                    max = Math.max(max, newArea);
                }
            }
        }

        return max;
    }

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int dfs(int[][] grid, int x, int y, int colorIndex) {
        if(grid[x][y] == 1) {
            int res = 1;
            grid[x][y] = colorIndex;
            for(int[] dir: dirs){
                int xNew = x + dir[0];
                int yNew = y + dir[1];
                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                    res += dfs(grid, xNew, yNew, colorIndex);
                }
            }
            return res;
        }
        return 0;
    }
}