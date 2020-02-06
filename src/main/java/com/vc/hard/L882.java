package com.vc.hard;

import java.util.*;

class L882 {
    class Entry {
        int to;
        int cost;
        Entry(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "("+to+" "+cost+")";
        }
    }

    private void print(int[][] graph) {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                System.out.format("%4d", graph[i][j]);
            }
            System.out.println();
        }
    }

    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = -1;
            }
        }

        for(int[] edge: edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
            graph[from][to] = cost;
            graph[to][from] = cost;
        }
        //print(graph);

        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(y[1], x[1]);
            }
        });

        q.offer(new int[]{0, M});
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;

        while(!q.isEmpty()) {
            int[] e = q.poll();
            int from = e[0], moves = e[1];

            if(visited.contains(from)) continue;

            visited.add(from);
            res++;
            for(int to = 0; to < N; to++) {
                if(graph[from][to] != -1) {
                    if(moves > graph[from][to]) {
                        q.offer(new int[]{to, moves - graph[from][to] - 1});
                    }
                    res += Math.min(moves, graph[from][to]);
                    graph[to][from] -= Math.min(moves, graph[from][to]);
                }
            }
        }
        return res;
    }
}
