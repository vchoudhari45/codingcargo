package com.vc.hard;

import java.util.*;

class L827 {
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        int colorIndex = 2;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int size = solve(grid, i, j, colorIndex);
                    map.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }

        int res = map.getOrDefault(2, 0);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> colors = new HashSet<Integer>();
                    colors.add(i > 0 ? grid[i - 1][j] : 0);
                    colors.add(j > 0 ? grid[i][j - 1] : 0);
                    colors.add(i < grid.length  - 1 ? grid[i + 1][j] : 0);
                    colors.add(j < grid[0].length - 1 ? grid[i][j + 1] : 0);

                    int newSize = 1;
                    for(Integer color: colors) {
                        newSize += map.getOrDefault(color, 0);
                        res = Math.max(res, newSize);
                    }
                }
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int solve(int[][] grid, int x, int y, int colorIndex) {
        if(grid[x][y] == 1) {
            int res = 1;
            grid[x][y] = colorIndex;
            for(int i = 0; i < dirs.length; i++) {
                int xNew = x + dirs[i][0];
                int yNew = y + dirs[i][1];
                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length && grid[xNew][yNew] == 1) {
                    res += solve(grid, xNew, yNew, colorIndex);
                }
            }
            return res;
        }
        return 0;
    }
}
