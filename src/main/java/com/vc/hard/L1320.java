package com.vc.hard;

import java.util.*;

class L1320 {
    public int minimumDistance(String word) {
        class State {
            int index, cost;
            char right;

            State(int index, char right, int cost) {
                this.index = index;
                this.right = right;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return index+" "+right+" "+cost;
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>(){
            public int compare(State s1, State s2) {
                return Integer.compare(s1.cost, s2.cost);
            }
        });

        //Right finger can start from any characters from A - Z
        for(char i = 'A'; i <= 'Z'; i++) {
            pq.offer(new State(0, i, 0));
        }

        int n = word.length();
        HashSet<String> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            State e = pq.poll();

            //System.out.println(e);

            if(e.index == n - 1) return e.cost;

            String key = e.index + " "+e.right;

            if(visited.contains(key)) continue;

            visited.add(key);

            int useLeft = e.cost + distance(word.charAt(e.index + 1), word.charAt(e.index));
            int useRight = e.cost + distance(word.charAt(e.index + 1), e.right);

            pq.offer(new State(e.index + 1, e.right, useLeft));
            pq.offer(new State(e.index + 1, word.charAt(e.index), useRight));
        }
        return -1;
    }

    private int distance(char from, char to) {
        int[] f = location(from);
        int[] t = location(to);
        return Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
    }

    private int[] location(char ch) {
        int r = (ch - 'A') / 6;
        int c = (ch - 'A') % 6;
        return new int[]{r, c};
    }
}
