package com.vc.medium;

import java.util.*;

class L1057 {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] d1, int[] d2) {
                int compareDistance = Integer.compare(d1[2], d2[2]);
                if(compareDistance == 0) {
                    int compareWorker = Integer.compare(d1[0], d2[0]);
                    if(compareWorker == 0) return Integer.compare(d1[1], d2[1]);
                    else return compareWorker;
                }
                return compareDistance;
            }
        });

        for(int w = 0; w < workers.length; w++) {
            for(int b = 0; b < bikes.length; b++) {
                int distance = getDistance(workers[w][0],workers[w][1],bikes[b][0],bikes[b][1]);
                pq.offer(new int[]{w, b, distance});
            }
        }

        HashSet<Integer> bset = new HashSet<>();
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);

        while(bset.size() < workers.length) {
            int[] e = pq.poll();
            int worker = e[0];
            int bike = e[1];
            int distance = e[2];
            if(!bset.contains(bike) && res[worker] == -1) {
                res[worker] = bike;
                bset.add(bike);
            }
        }
        return res;
    }

    private int getDistance(int wx, int wy, int bx, int by) {
        return Math.abs(wx - bx) + Math.abs(wy - by);
    }
}
