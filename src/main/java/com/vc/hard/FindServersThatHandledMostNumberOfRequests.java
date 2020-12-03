package com.vc.hard;

import java.util.*;

class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for(int server = 0; server < k; server++) available.add(server);

        //[server, busyUntil order by Asc]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int cmp = Integer.compare(x[1], y[1]);
                if(cmp == 0) return Integer.compare(x[0], y[0]);
                return cmp;
            }
        });

        int[] count = new int[k];
        int max = 0;
        for(int i = 0; i < arrival.length; i++) {
            int serverIndex = i % k;
            int arrivalTime = arrival[i];
            while(!pq.isEmpty() && pq.peek()[1] <= arrivalTime) {
                available.add(pq.poll()[0]);
            }
            Integer availableServer = available.ceiling(serverIndex);

            //wrapping around
            if(availableServer == null) availableServer = available.ceiling(0);

            if(availableServer != null) {
                int busyUntil = arrivalTime + load[i];
                pq.offer(new int[]{availableServer, busyUntil});
                available.remove(availableServer);
                count[availableServer]++;
                max = Math.max(max, count[availableServer]);
            }
        }

        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < k; i++) if(count[i] == max) res.add(i);

        return res;
    }
}