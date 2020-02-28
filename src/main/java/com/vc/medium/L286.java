package com.vc.medium;

import java.util.*;

class L286 {
    private int[][] rooms;

    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;

        int n = rooms.length;
        if(n == 0) return;

        int m = rooms[0].length;
        if(m == 0) return;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rooms[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] e = q.poll();
            //System.out.println(e[0]+" "+e[1]);
            for(int[] dir: dirs) {
                int rowNew = e[0] + dir[0];
                int colNew = e[1] + dir[1];

                if(rowNew >= 0 && rowNew < rooms.length && colNew >= 0
                        && colNew < rooms[0].length) {
                    if(rooms[rowNew][colNew] == -1) continue;
                    if(rooms[rowNew][colNew] > rooms[e[0]][e[1]] + 1) {
                        rooms[rowNew][colNew] = rooms[e[0]][e[1]] + 1;
                        q.offer(new int[]{rowNew, colNew});
                    }
                }
            }
        }
    }
}
