package com.vc.hard;

import java.util.*;

class L1293 {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        Queue<int[]> q = new LinkedList<>();    //int[] stands for x, y, k
        HashSet<String> visited = new HashSet<>();

        q.offer(new int[]{0, 0, k});
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            //System.out.println("================================================");
            for(int i = 0; i < size; i++) {
                int[] e = q.poll();
                int x = e[0], y = e[1], remaining = e[2];

                //System.out.println("x: "+x+" y: "+y+" remaining: "+remaining);
                if(x == n - 1 && y == m - 1) return level;

                String key = x+" "+y+" "+remaining;
                if(visited.contains(key)) continue;

                visited.add(key);
                for(int[] dir: dirs) {
                    int xNew = x + dir[0];
                    int yNew = y + dir[1];
                    if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m) {
                        if(grid[xNew][yNew] == 1) {
                            if(remaining > 0) q.offer(new int[]{xNew, yNew, remaining - 1});
                        }
                        else q.offer(new int[]{xNew, yNew, remaining});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
