package com.vc.medium;

import java.util.*;

class L1066 {
    class State {
        int worker;
        int distance;
        int mask;

        public State(int worker, int distance, int mask) {
            this.worker = worker;
            this.distance = distance;
            this.mask = mask;
        }

        @Override
        public String toString() {
            return "worker: "+worker+" distance: "+distance+" mask: "+Integer.toBinaryString(mask);
        }
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>(){
            public int compare(State s1, State s2) {
                return s1.distance - s2.distance;
            }
        });
        HashSet<String> visited = new HashSet<>();

        pq.offer(new State(0, 0, 0));
        while(!pq.isEmpty()) {
            State state = pq.poll();

            //System.out.println(state);

            if(state.worker == workers.length) return state.distance;

            String key = state.worker+"->"+state.mask;
            if(visited.contains(key)) continue;

            visited.add(key);
            for(int b = 0; b < bikes.length; b++) {
                if((state.mask & (1 << b)) == 0) {
                    int newMask = state.mask | (1 << b);
                    int newDistance = state.distance + getDistance(workers[state.worker], bikes[b]);
                    pq.offer(new State(state.worker + 1, newDistance, newMask));
                }
            }
        }
        return -1;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}