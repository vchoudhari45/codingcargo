package com.vc.hard;

import java.util.*;

class L675 {

    static class Entry{
        int row;
        int col;
        int val;

        Entry(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public String toString() {
            return "(row: "+row+" col: "+col+" val: "+val+")";
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        /**
             [
                 [2,3,4],
                 [0,0,5],
                 [8,7,6]
             ]
         */
        if(forest == null) return 0;

        int n = forest.size();
        if(n == 0) return 0;
        int m = forest.get(0).size();

        PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.valueOf(e1.val).compareTo(e2.val);
            }
        });

        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if(val >= 1) {
                    pq.offer(new Entry(i, j, val));
                }
            }
        }

        int res = 0;
        Entry prev = new Entry(0, 0, forest.get(0).get(0));
        while(!pq.isEmpty()) {
            Entry current = pq.poll();
            int distance = getDistance(forest, prev, current, n, m);
            //System.out.println("Distance from: "+prev+" to: "+current+" is: "+distance);
            if(distance == -1) return -1;
            res += distance;
            prev = current;
            forest.get(current.row).set(current.col, 1);
        }
        return res;
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private int getDistance(List<List<Integer>> forest,
                            Entry current, Entry target, int totalRow, int totalCol) {
        Queue<Entry> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(current);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Entry e = q.poll();
                if(e.row == target.row && e.col == target.col) return level;
                if(!visited.contains(e.row+" "+e.col)) {
                    //System.out.println("Row: "+e.row+" Col: "+e.col+" Val: "+e.val);
                    visited.add(e.row+" "+e.col);
                    for(int[] dir: dirs) {
                        int rowNew = e.row + dir[0];
                        int colNew = e.col + dir[1];
                        if(rowNew >= 0 && rowNew < totalRow &&
                                colNew >= 0 && colNew < totalCol)  {
                            if(forest.get(rowNew).get(colNew) == 0)
                                visited.add(rowNew+" "+colNew);
                            else
                                q.offer(new Entry(rowNew, colNew, forest.get(rowNew).get(colNew)));
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}