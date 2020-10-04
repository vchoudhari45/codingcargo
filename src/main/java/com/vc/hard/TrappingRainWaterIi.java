package com.vc.hard;

import java.util.*;

class TrappingRainWaterIi {
    public int trapRainWater(int[][] height) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[0], y[0]);
            }
        });

        int row = 0;
        int col = 0;
        int n = height.length;
        int m = height[0].length;

        while(col < m) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            col++;
        }
        row++;
        col--;

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
        row--;
        col++;

        while(row > 0) {
            pq.offer(new int[]{height[row][col], row, col});
            height[row][col] = -1;
            row--;
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 0;
        int res = 0;
        while(!pq.isEmpty()) {
            int[] entry = pq.poll();
            max = Math.max(entry[0], max);
            for(int[] dir: dirs) {
                int xNew = entry[1] + dir[0];
                int yNew = entry[2] + dir[1];
                if(xNew >= 0 && xNew < height.length && yNew >= 0 && yNew < height[0].length && height[xNew][yNew] != -1) {
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