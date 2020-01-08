package com.vc.hard;

import java.util.*;

class L818 {
    static class State {
        int position = 0;
        int speed = 0;
        State(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "position: "+position+" speed: "+speed;
        }
    }

    public int racecar(int target) {
        State initial = new State(0, 1);
        Queue<State> q = new LinkedList<>();
        q.add(initial);

        HashSet<String> visited = new HashSet<>();
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                State state = q.poll();

                //System.out.println(state);

                if(state.position == target) return count;

                String stateKey = state.position+" "+state.speed;
                if(visited.contains(stateKey)) continue;
                visited.add(stateKey);

                //Try A
                if(0 < state.position + state.speed && state.position + state.speed < (target << 1)){
                    State newStateA = new State(state.position + state.speed, state.speed * 2);
                    q.offer(newStateA);
                }

                //Try R
                State newStateR = new State(state.position, state.speed > 0 ? -1 : 1);
                q.offer(newStateR);

            }
            count++;
        }
        return -1;
    }
}