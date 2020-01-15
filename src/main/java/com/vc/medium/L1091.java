package com.vc.medium;

import java.util.*;

class L1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1},{1, 1},{-1, -1},{1, -1},{-1, 1}};
        HashSet<String> visited = new HashSet<>();
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            //System.out.println("size: "+size);
            for(int i = 0; i < size; i++) {
                int[] e = q.poll();
                //System.out.println(e[0]+"->"+e[1]);
                if(e[0] == grid.length - 1 && e[1] == grid[0].length - 1) return level;
                if(visited.contains(e[0]+"->"+e[1])) continue;
                visited.add(e[0]+"->"+e[1]);

                for(int[] dir: dirs) {
                    int xNew = e[0] + dir[0];
                    int yNew = e[1] + dir[1];
                    if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                            && grid[xNew][yNew] == 0 && !visited.contains(xNew+"->"+yNew)) {
                        q.offer(new int[]{xNew, yNew});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
