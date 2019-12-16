package com.vc.hard;

import java.util.*;

class L317 {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;

        int[][] total = new int[n][m];
        int[][] count = new int[n][m];
        int countBuilding = 0;

        int[][] dirs = {{0, 1},{0, -1},{-1, 0},{1, 0}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    countBuilding++;
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] visited = new boolean[n][m];
                    int level = 0;
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int k = 0; k < size; k++) {
                            int[] e = q.poll();
                            int x = e[0];
                            int y = e[1];
                            if(!visited[x][y] && grid[x][y] != 2) {
                                visited[x][y] = true;
                                for(int[] dir: dirs) {
                                    int xNew = x + dir[0];
                                    int yNew = y + dir[1];
                                    if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < m
                                            && grid[xNew][yNew] != 1 && grid[xNew][yNew] != 2) {
                                        q.offer(new int[]{xNew, yNew});
                                    }
                                }
                                if(grid[x][y] == 0) {
                                    total[x][y] += level;
                                    count[x][y]++;
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
//         System.out.println("Total: ");
//         for(int i = 0; i < total.length; i++) {
//             for(int j = 0; j < total[0].length; j++) {
//                 System.out.format("%5d", total[i][j]);
//             }
//             System.out.println();
//         }

//         System.out.println("Count: "+countBuilding);
//         for(int i = 0; i < count.length; i++) {
//             for(int j = 0; j < count[0].length; j++) {
//                 System.out.format("%5d", count[i][j]);
//             }
//             System.out.println();
//         }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < total.length; i++) {
            for(int j = 0; j < total[0].length; j++) {
                if(count[i][j] == countBuilding) res = Math.min(res, total[i][j]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
