package com.vc.easy;

import java.util.*;

class L1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        int numRow = grid.length;
        if(numRow == 0) return list;
        int numCol = grid[0].length;

        for(int i = 0; i < numRow; i++) {
            List<Integer> cols = new ArrayList<>();
            for(int j = 0; j < numCol; j++) {
                cols.add(0);
            }
            list.add(cols);
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int newRow = (i + (j + k) / numCol) % numRow;
                int newCol = (j + k) % numCol;
                list.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return list;
    }
}
