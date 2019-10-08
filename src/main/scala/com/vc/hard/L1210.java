package com.vc.hard;

import java.util.*;

class L1210 {
    public int minimumMoves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new int[] {0, 1});
        visited.add("0-1");

        int n = grid.length;
        int moves = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] span = q.poll();
                int first = span[0];
                int second = span[1];

                int x1 = first / n;
                int y1 = first % n;

                int x2 = second / n;
                int y2 = second % n;

                if(x1 == n - 1 && y1 == n - 2 && x2 == n - 1 && y2 == n - 1) return moves;

                if(x1 == x2) { //horizontal
                    if(y2 + 1 < n && grid[x1][y2 + 1] == 0) move(q, visited, second, second + 1); // move right
                    if(x1 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x1 + 1][y2] == 0) {
                        move(q, visited, first + n, second + n); //down
                        move(q, visited, first, first + n);      //clockwise
                    }
                }

                if(y1 == y2) { //vertical
                    if(x2 + 1 < n && grid[x2 + 1][y1] == 0) move(q, visited, second, second + n); //move down
                    if(y1 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
                        move(q, visited, first + 1, second + 1); //right
                        move(q, visited, first, first + 1); //counterclockwise
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private void move(Queue<int[]> q, Set<String> visited, int first, int second) {
        if(!visited.contains(first+"-"+second)) {
            q.add(new int[]{first, second});
            visited.add(first+"-"+second);
        }
    }
}
