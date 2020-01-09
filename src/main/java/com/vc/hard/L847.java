package com.vc.hard;

import java.util.*;

class L847 {

    static class Entry {
        int state = 0;
        int index = 0;
        Entry(int state, int index) {
            this.state = state;
            this.index = index;
        }

        @Override
        public String toString() {
            return state+" "+index;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int target = 0;
        int n = graph.length;

        Queue<Entry> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            target = target | (1 << i);
            int element = 1 << i;
            q.offer(new Entry(element, i));
        }

        HashSet<String> visited = new HashSet<>();
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Entry e = q.poll();

                // System.out.println("state "
                //                    +String.format("%4s", Integer.toBinaryString(e.state)).replace(' ', '0')
                //                    +" state "+e.state
                //                    +" graphIndex: "+e.index);

                if(e.state == target) return level;

                if(visited.contains(e.state+" "+e.index)) continue;

                visited.add(e.state+" "+e.index);
                for(int j = 0; j < graph[e.index].length; j++) {
                    int destination = graph[e.index][j];

                    int newState = e.state | (1 << destination);

                    if(visited.contains(newState+" "+destination)) continue;
                    q.offer(new Entry(newState, destination));
                }
            }
            level++;
        }
        return level;
    }
}
