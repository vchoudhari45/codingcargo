package com.vc.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

class Entry {
    int val;
    int row;
    int col;

    Entry(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return val+" "+row+" "+col;
    }
}
class L1102 {
    private int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.compare(e2.val, e1.val);
            }
        });

        int n = A.length, m = A[0].length;
        boolean[][] visited = new boolean[n][m];

        pq.offer(new Entry(A[0][0], 0, 0));
        int maxValue = A[0][0];

        while(!pq.isEmpty()) {
            Entry element = pq.poll();

            if(visited[element.row][element.col]) continue;

            visited[element.row][element.col] = true;

            maxValue = Math.min(maxValue, element.val);

            if(element.row == n - 1 && element.col == m - 1) return maxValue;

            for(int[] dir: dirs) {
                int rowNew = element.row + dir[0];
                int colNew = element.col + dir[1];
                if(rowNew >= 0 && rowNew < n && colNew >= 0 && colNew < m) {
                    pq.offer(new Entry(A[rowNew][colNew], rowNew, colNew));
                }
            }
        }
        return maxValue;
    }
}
