package com.vc.hard;

import java.util.*;

class TheMazeIii {
    static class State {
        int x, y, distance;
        String path;
        State(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public String toString() {
            return x+" "+y+" "+distance+" "+path;
        }
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private String[] dirValue = {"d", "r", "u", "l"};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>(){
            public int compare(State s1, State s2) {
                int cmp = Integer.compare(s1.distance, s2.distance);
                if(cmp == 0) return s1.path.compareTo(s2.path);
                else return cmp;
            }
        });

        pq.offer(new State(ball[0], ball[1], 0, ""));
        HashSet<String> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            State state = pq.poll();

            if(state.x == hole[0] && state.y == hole[1]) return state.path;

            String key = state.x + " " + state.y;
            if(visited.contains(key)) continue;

            visited.add(key);
            for(int i = 0; i < dirs.length; i++) {
                State newState = move(state, maze, hole, dirs[i], dirValue[i]);
                if((newState.x == state.x && newState.y == state.y) ||
                        visited.contains(newState.x+" "+newState.y)) continue;
                pq.offer(newState);
            }
        }

        return "impossible";
    }

    private State move(State state, int[][] maze, int[] hole, int[] dir, String dirValue) {
        int xNew = state.x;
        int yNew = state.y;
        int res = 0;
        while(xNew + dir[0] >= 0 && xNew + dir[0] < maze.length &&
                yNew + dir[1] >= 0 && yNew + dir[1] < maze[0].length &&
                maze[xNew + dir[0]][yNew + dir[1]] == 0) {

            xNew = xNew + dir[0];
            yNew = yNew + dir[1];

            res++;
            if(xNew == hole[0] && yNew == hole[1]) break;
        }
        return new State(xNew, yNew, state.distance + res, state.path + dirValue);
    }
}