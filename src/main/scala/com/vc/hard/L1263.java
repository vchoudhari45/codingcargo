package com.vc.hard;

import java.util.*;

class L1263 {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        int[] start = new int[4];
        int[] target = new int[2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(grid[i][j] == 'B') {
                    start[2] = i;
                    start[3] = j;
                }
                else if(grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        HashSet<String> visited = new HashSet<>();
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0)  {
                int[] e = q.poll();
                int sx = e[0];
                int sy = e[1];
                int bx = e[2];
                int by = e[3];

                String key = sx+" "+sy+" "+bx+" "+by;
                if(bx == target[0] && by == target[1]) return level;
                if(!visited.contains(key)) {
                    //System.out.println(key);
                    visited.add(key);
                    boolean[][] canVisit = new boolean[m][n];
                    updateCanVisit(grid, canVisit, sx, sy, bx, by);

                    for(int[] dir: dirs) {
                        int sxNew = bx - dir[0];
                        int syNew = by - dir[1];

                        int bxNew = bx + dir[0];
                        int byNew = by + dir[1];

                        //System.out.println(sxNew+" "+syNew+" "+bxNew+" "+byNew+" "+canVisit[sxNew][syNew]+" "+grid[bxNew][byNew]);

                        if(sxNew >= 0 && sxNew < m && syNew >= 0 && syNew < n &&
                                bxNew >= 0 && bxNew < m && byNew >= 0 && byNew < n &&
                                grid[bxNew][byNew] != '#' &&
                                canVisit[sxNew][syNew] &&
                                !visited.contains(sxNew+" "+syNew+" "+bxNew+" "+byNew)) {
                            q.offer(new int[]{sxNew, syNew, bxNew, byNew});
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    private void updateCanVisit(char[][] grid, boolean[][] canVisit, int i, int j, int bi, int bj) {
        if(i >= 0 && j >= 0 && i < canVisit.length && j < canVisit[0].length
                && grid[i][j] != '#' && !(i == bi && j == bj) && !canVisit[i][j]) {
            canVisit[i][j] = true;
            for(int[] dir : dirs) {
                updateCanVisit(grid, canVisit, i + dir[0], j + dir[1], bi, bj);
            }
        }
    }
}