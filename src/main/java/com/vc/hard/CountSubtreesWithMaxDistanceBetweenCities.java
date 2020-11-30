package com.vc.hard;

class CountSubtreesWithMaxDistanceBetweenCities {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] distance = new int[n][n];

        //Assign not reachable for all the combinations except where from == to
        for(int from = 0; from < n; from++) {
            for(int to = 0; to < n; to++) {
                if(from != to) distance[from][to] = Integer.MAX_VALUE;
            }
        }

        //If edge is present assign distance as 1
        for(int[] edge: edges) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            distance[from][to] = 1;
            distance[to][from] = 1;
        }

        //Calculate distance using floyd Warshall
        for(int via = 0; via < n; via++) {
            for(int from = 0; from < n; from++) {
                for(int to = 0; to < n; to++) {
                    if(from != to &&
                            distance[from][via] != Integer.MAX_VALUE && distance[via][to] != Integer.MAX_VALUE) {
                        distance[from][to] = Math.min(distance[from][to],
                                distance[from][via] + distance[via][to]);
                    }
                }
            }
        }

        int[] res = new int[n - 1];
        //Loop through all the subsets and see if it is sub-tree
        //If it is subtree, return maxDistance between any two nodes in a sub tree
        for(int state = 0; state < (1 << n); state++) {
            int maxDistance = maxDistance(state, distance, n);
            if(maxDistance > 0) res[maxDistance - 1]++;
        }
        return res;
    }

    private int maxDistance(int state, int[][] distance, int n) {
        int countCity = 0, countEdge = 0, maxDistance = 0;
        for(int from = 0; from < n; from++) {
            if((state & (1 << from)) == 0) continue;
            countCity++;
            for(int to = from; to < n; to++) {
                if((state & (1 << to)) == 0) continue;
                countEdge += distance[from][to] == 1 ? 1 : 0;
                maxDistance = Math.max(maxDistance, distance[from][to]);
            }
        }
        if(countEdge != countCity - 1) return 0; //Subset is not valid subtree
        return maxDistance;
    }
}