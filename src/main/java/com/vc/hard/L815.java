package com.vc.hard;

import java.util.*;

class L815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        /**
             [1, 2, 7]
             [3, 6, 7]

             1 -> 0
             2 -> 0
             7 -> 0, 1
             3 -> 1
             6 -> 1
             7 -> 1
        */
        if(S == T) return 0;
        HashMap<Integer, HashSet<Integer>> stations = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                int station = routes[i][j];
                HashSet<Integer> buses = stations.getOrDefault(station, new HashSet<Integer>());
                buses.add(i);
                stations.put(station, buses);
            }
        }
        //System.out.println(stations);

        //BFS
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> stationVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        q.add(S);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int station = q.poll();

                if(station == T) return count;

                if(stationVisited.contains(station)) continue;

                stationVisited.add(station);
                for(int bus: stations.get(station)) {
                    if(busVisited.contains(bus)) continue;

                    busVisited.add(bus);
                    for(int newStation: routes[bus]) {
                        if(!stationVisited.contains(newStation)) q.offer(newStation);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
