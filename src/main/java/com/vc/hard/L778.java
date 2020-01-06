package com.vc.hard;

import java.util.*;

class L778 {

    static class Entry {
        int x;
        int y;
        int val;

        Entry(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "("+x + ", "+y+", "+val+")";
        }
    }

    int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.valueOf(e1.val).compareTo(e2.val);
            }
        });

        pq.offer(new Entry(0, 0, grid[0][0]));
        int res = 0;

        while(!pq.isEmpty()) {
            Entry e = pq.poll();
            res = Math.max(e.val, res);
            if(e.x == grid.length - 1 && e.y == grid[0].length - 1) return res;

            //System.out.println("x: "+e.x+" y: "+e.y+" res: "+res+" pq: "+pq+" val: "+grid[e.x][e.y]);

            if(grid[e.x][e.y] == -1) continue;
            grid[e.x][e.y] = -1;
            for(int[] dir: dirs) {
                int xNew = e.x + dir[0];
                int yNew = e.y + dir[1];
                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                    pq.offer(new Entry(xNew, yNew, grid[xNew][yNew]));
                    //System.out.println("x: "+xNew+" y: "+yNew+" res: "+res+" pq: "+pq);
                }
            }
        }
        return res;
    }
}
