package com.vc.hard;

import java.util.*;

class L834 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            List<Integer> list = map.getOrDefault(from, new ArrayList<Integer>());
            list.add(to);
            map.put(from, list);

            List<Integer> list2 = map.getOrDefault(to, new ArrayList<Integer>());
            list2.add(from);
            map.put(to, list2);
        }

        //dist[i] = sum distance of node i from every other node in a graph
        int dist[] = new int[N];

        //count[i] = number of childrens of node i
        int count[] = new int[N];

        //System.out.println(map);
        fromParentToChild(0, -1, dist, count, map);
        fromChildToParent(0, -1, dist, count, map);
        return dist;
    }

    private void fromParentToChild(int current, int root, int[] dist,
                                   int[] count, HashMap<Integer, List<Integer>> map) {
        if(map.containsKey(current)) {
            for(Integer child: map.get(current)) {
                if(child != root) {
                    fromParentToChild(child, current, dist, count, map);
                    count[current] += count[child];
                    /**
                         dist[current] = distance of current node from all the other nodes in a graph
                         dist[child] = distance of child node from all the other nodes in a graph

                         Distance of current from to it's child Node is 1
                         And let's say child node has 3 children,
                         so distance of current node from all of those child's 3 children node will be
                         dist[child] + count[child]

                         For e.g.
                             0(current Node)
                              \
                              2 (level 1 child Node)
                             /|\
                             3 4 5 (3 child node of level 1 child node)

                         sum of distance of 3, 4, 5 from 2 will be 3
                         distance of 2 from 1 is 1
                         so distance of 3, 4, 5 from 1 will be dist[child] + count[child] = 3 + 3
                     */
                    dist[current] += dist[child] + count[child];
                }
            }
        }
        count[current] += 1;
    }

    private void fromChildToParent(int current, int root, int[] dist,
                                   int[] count, HashMap<Integer, List<Integer>> map) {
        if(map.containsKey(current)) {
            for(Integer child: map.get(current)) {
                if(child != root) {
                    dist[child] = dist[current] - count[child] + count.length - count[child];
                    fromChildToParent(child, current, dist, count, map);
                }
            }
        }
    }
}
