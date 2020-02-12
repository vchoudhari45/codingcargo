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

                int tailX = first / n;
                int tailY = first % n;

                int headX = second / n;
                int headY = second % n;

                if(tailX == n - 1 && tailY == n - 2 && headX == n - 1 && headY == n - 1) return moves;

                if(tailX == headX) { //horizontal
                    if(headY + 1 < n && grid[tailX][headY + 1] == 0) move(q, visited, second, second + 1); // move right
                    if(tailX + 1 < n && grid[tailX + 1][tailY] == 0 && grid[tailX + 1][headY] == 0) {
                        move(q, visited, first + n, second + n); //down
                        move(q, visited, first, first + n);      //clockwise
                    }
                }

                if(tailY == headY) { //vertical
                    if(headX + 1 < n && grid[headX + 1][tailY] == 0) move(q, visited, second, second + n); //move down
                    if(tailY + 1 < n && grid[tailX][tailY + 1] == 0 && grid[headX][headY + 1] == 0) {
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
