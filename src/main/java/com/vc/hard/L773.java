package com.vc.hard;

import java.util.*;

class L773 {

    static class Entry {
        String state;
        int emptySlot;

        Entry(String state, int emptySlot) {
            this.state = state;
            this.emptySlot = emptySlot;
        }

        @Override
        public String toString() {
            return ""+state+" "+emptySlot;
        }
    }

    private String target = "123450";
    private int[][] dirs = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
    };

    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                start.append(board[i][j]);
            }
        }

        Queue<Entry> q = new LinkedList<>();
        q.add(new Entry(start.toString(), start.toString().indexOf('0')));

        HashSet<String> visited = new HashSet<>();
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Entry entry = q.poll();
                //System.out.println(entry);

                if(entry.state.equals(target)) return level;
                if(visited.contains(entry.state+" "+entry.emptySlot)) continue;

                visited.add(entry.state+" "+entry.emptySlot);
                int oldIndex = entry.emptySlot;
                for(int newIndex: dirs[oldIndex]) {
                    char[] c = entry.state.toCharArray();
                    c[oldIndex] = c[newIndex];
                    c[newIndex] = '0';
                    String newState = new String(c);
                    q.offer(new Entry(newState, newIndex));
                }

            }
            level++;
        }
        return -1;
    }
}
