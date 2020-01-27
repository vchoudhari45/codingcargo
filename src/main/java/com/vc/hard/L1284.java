package com.vc.hard;

import java.util.*;

class L1284 {

    static class State {
        int hash;
        int cost;

        State(int hash, int cost) {
            this.hash = hash;
            this.cost = cost;
        }
    }

    public int minFlips(int[][] matrix) {
        Queue<State> pq = new LinkedList<>();

        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new State(hash(matrix), 0));

        while(!pq.isEmpty()) {
            int size = pq.size();
            for(int i = 0; i < size; i++) {
                State e = pq.poll();

                if(e.hash == 0) return e.cost;

                if(visited.contains(e.hash)) continue;

                visited.add(e.hash);
                generate(e.hash, pq, e.cost, matrix.length, matrix[0].length);
            }
        }
        return -1;
    }

    private int hash(int[][] matrix) {
        int hash = 0;
        for(int i = 0; i < matrix.length * matrix[0].length; i++) {
            int r = i / matrix[0].length;
            int c = i % matrix[0].length;
            if(matrix[r][c] == 1) {
                hash |= 1 << i;
            }
        }
        return hash;
    }

    private int[][] dirs = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void generate(int hash, Queue<State> pq, int cost, int m, int n) {
        for(int i = 0; i < m * n; i++) {
            int r = i / n;
            int c = i % n;

            int newHash = hash;
            for(int[] dir: dirs) {
                int rNew = r + dir[0];
                int cNew = c + dir[1];

                if(rNew >= 0 && rNew < m && cNew >= 0 && cNew < n) {
                    newHash ^= 1 << (rNew * n + cNew);
                }
            }
            pq.offer(new State(newHash, cost + 1));
        }
    }
}
