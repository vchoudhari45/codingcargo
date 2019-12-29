package com.vc.hard;

import java.util.*;

class L630 {

    static class Entry {
        int time;
        int endBefore;
        Entry(int time, int endBefore) {
            this.time = time;
            this.endBefore = endBefore;
        }

        @Override
        public String toString() {
            return "(time: "+time+" endBefore: "+endBefore+")";
        }
    }

    public int scheduleCourse(int[][] courses) {
        /**
         [100, 200], [1000, 1250], [200, 1300], [2000, 3200]

         [100, 200]    -> 10
         [1000, 1250]  -> 1100
         [200, 1300]   -> 1300
         */
        PriorityQueue<Entry> pqEnd = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.valueOf(e1.endBefore).compareTo(e2.endBefore);
            }
        });

        PriorityQueue<Entry> pqTime = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.valueOf(e2.time).compareTo(e1.time);
            }
        });

        for(int i = 0; i < courses.length; i++) {
            pqEnd.offer(new Entry(courses[i][0], courses[i][1]));
        }

        int currentTime = 0;
        while(!pqEnd.isEmpty()) {
            Entry e = pqEnd.poll();
            pqTime.offer(e);
            currentTime += e.time;
            //System.out.println("Adding entry: "+e+" currentTime: "+currentTime);
            if(currentTime > e.endBefore) {
                Entry bigTime = pqTime.poll();
                currentTime -= bigTime.time;
                //System.out.println("Time exceeded removing: "+bigTime+" currentTime: "+currentTime);
            }
        }
        return pqTime.size();
    }
}
