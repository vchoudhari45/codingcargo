package com.vc.medium;

import java.util.*;
g
class L1197 {
    private int[][] dirs = {{2, 1},{1, 2},{-1, 2},{-2, 1}, {-2, -1},{-1, -2},{1, -2},{2, -1}};

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        HashSet<String> visited = new HashSet<>();
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] e = q.poll();

                if(e[0] == x && e[1] == y) return level;

                if(visited.contains(e[0]+","+e[1])) continue;

                visited.add(e[0]+","+e[1]);
                for(int[] dir: dirs) {
                    int xNew = e[0] + dir[0];
                    int yNew = e[1] + dir[1];
                    if(!visited.contains(xNew+","+yNew) && xNew >= -1 && yNew >= -1) {
                        q.offer(new int[]{xNew, yNew});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
