package com.vc.medium;

class L1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Floyd Warshall Algorithm
        int[][] distance = new int[n][n];

        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance[0].length; j++) distance[i][j] = 100001;
        }

        for(int[] edge: edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight;
        }

        for(int i = 0; i < distance.length; i++) distance[i][i] = 0;

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%06d", distance[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        int minCount = n;
        int node = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = 0; j < n; j++) {
                if(distance[i][j] <= distanceThreshold) count++;
            }

            if(minCount >= count) {
                minCount = count;
                node = i;
            }
        }
        return node;
    }
}
