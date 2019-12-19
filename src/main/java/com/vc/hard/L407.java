package com.vc.hard;

import java.util.*;

class L407 {
    public int trapRainWater(int[][] height) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });
        int row = 0;
        int col = 0;
        int n = height.length;
        if(n == 0) return 0;
        int m = height[0].length;

        int[][] dirs = {{0, 1},{0, -1},{-1, 0},{1, 0}};
        while(col < m) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            col++;
        }
        col--;
        row++;

        while(row < n) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            row++;
        }
        row--;
        col--;

        while(col >= 0) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            col--;
        }
        col++;
        row--;

        while(row > 0) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            row--;
        }

        int res = 0;
        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            int[] e = pq.poll();
            max = Math.max(max, e[0]);
            for(int[] dir: dirs) {
                int xNew = dir[0] + e[1];
                int yNew = dir[1] + e[2];
                if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m && height[xNew][yNew] != -1) {
                    if(max > height[xNew][yNew]) {
                        res += (max - height[xNew][yNew]);
                    }
                    pq.offer(new int[]{height[xNew][yNew], xNew, yNew});
                    height[xNew][yNew] = -1;
                }
            }
        }
        return res;
    }
}