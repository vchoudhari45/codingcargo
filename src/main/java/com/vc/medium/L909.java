package com.vc.medium;

import java.util.*;

class L909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if(n == 0) return 0;

        int[] b = new int[n * n + 1];
        boolean ltr = true;
        int index = 1;
        for(int row = n - 1; row >= 0; row--) {
            if(ltr) {
                for(int col = 0; col < n; col++) {
                    b[index++] = board[row][col];
                }
                ltr = false;
            }
            else {
                for(int col = n - 1; col >= 0; col--) {
                    b[index++] = board[row][col];
                }
                ltr = true;
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int start = b[1] > -1 ? b[1] : 1;
        q.offer(start);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int pos = q.poll();

                if(pos == n * n) return level;

                if(visited.contains(pos)) continue;

                visited.add(pos);
                for(int dice = 1; dice <= 6; dice++) {
                    int newPos = pos + dice;
                    if(newPos <= n * n){
                        if(b[newPos] > -1) q.offer(b[newPos]);
                        else q.offer(newPos);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
