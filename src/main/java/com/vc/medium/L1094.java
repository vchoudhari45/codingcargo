package com.vc.medium;

import java.util.*;

class L1094 {
    class Entry {
        int location;
        int passengers;
        boolean isPickup;

        Entry(int location, int passengers, boolean isPickup) {
            this.location = location;
            this.passengers = passengers;
            this.isPickup = isPickup;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        /**
             1 2 P
             3 3 P
             5 2 D
             7 3 D
        */
        PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                int cmp = Integer.compare(e1.location, e2.location);
                if(cmp == 0) {
                    if(e1.isPickup) return 1;
                    else return -1;
                }
                return cmp;
            }
        });

        for(int[] trip: trips) {
            int passengers = trip[0];
            int pickLocation = trip[1];
            int dropLocation = trip[2];

            Entry ePick = new Entry(pickLocation, passengers, true);
            Entry eDrop = new Entry(dropLocation, passengers, false);

            pq.offer(ePick);
            pq.offer(eDrop);
        }

        int currentCapacity = 0;
        while(!pq.isEmpty()) {
            Entry e = pq.poll();

            if(e.isPickup) currentCapacity += e.passengers;
            else currentCapacity -= e.passengers;

            if(currentCapacity > capacity) return false;
        }
        return true;
    }
}
