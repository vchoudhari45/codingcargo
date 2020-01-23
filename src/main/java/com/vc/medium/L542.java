package com.vc.medium;

import java.util.*;

class L542 {
    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) q.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            int[] e = q.poll();
            int x = e[0], y = e[1];
            for(int[] dir: dirs) {
                int xNew = x + dir[0];
                int yNew = y + dir[1];
                if(xNew >= 0 && xNew < matrix.length && yNew >= 0 && yNew < matrix[0].length
                        && matrix[xNew][yNew] > matrix[x][y] + 1) {
                    matrix[xNew][yNew] = matrix[x][y] + 1;
                    q.offer(new int[]{xNew, yNew});
                }
            }
        }
        return matrix;
    }
}
