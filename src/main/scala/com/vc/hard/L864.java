package com.vc.hard;

import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        /**
         [
         "@.a.#",
         "###.#",
         "b.A.B"
         ]
         */
        if(grid == null) return 0;
        int n = grid.length;
        if(n == 0) return 0;

        int[] start = new int[3];
        int totalKeys = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < grid[i].length(); j++){
                char ch = grid[i].charAt(j);
                if(ch == '@') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(ch >= 'a' && ch <= 'f') {
                    totalKeys |= 1 << (ch - 'a');
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int totalSteps = 0;
        Queue<int[]> q = new LinkedList();
        HashSet<String> visited = new HashSet<String>();
        q.add(start);
        visited.add(start[0]+" "+start[1]+" "+start[2]);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] e = q.poll();
                if(e[2] == totalKeys) return totalSteps;

                for(int[] dir: dirs) {
                    int xNew = e[0] + dir[0];
                    int yNew = e[1] + dir[1];
                    int keys = e[2];

                    if(xNew >= 0 && xNew < n && yNew >= 0 && yNew < grid[0].length()) {
                        char ch = grid[xNew].charAt(yNew);

                        if(ch == '#') continue;

                        if(ch >= 'a' && ch <= 'f') {
                            keys |= 1 << (ch - 'a');
                        }

                        int x = (keys >> (ch - 'A'));
                        if(ch >= 'A' && ch <= 'F' && ((x & 1) == 0)) continue;

                        String strVisited = xNew+" "+yNew+" "+keys;
                        if(!visited.contains(strVisited)) {
                            visited.add(strVisited);
                            q.offer(new int[]{xNew, yNew, keys});
                        }
                    }
                }
            }
            totalSteps++;
        }
        return -1;
    }
}