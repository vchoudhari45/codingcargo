package com.vc.medium;

import java.util.*;

class MyCalendarTwo {

    static class Entry {
        int time;
        boolean start;

        Entry(int time, boolean start) {
            this.time = time;
            this.start = start;
        }

        @Override
        public String toString() {
            return (time +", "+ start);
        }
    }

    static class CustomComparator implements Comparator<Entry> {
        public int compare(Entry e1, Entry e2) {
            int cmp = Integer.compare(e1.time, e2.time);
            if(cmp == 0) {
                if(!e1.start) return -1;
                else return 1;
            }
            else return cmp;
        }
    }

    PriorityQueue<Entry> pq;
    public MyCalendarTwo() {
        pq = new PriorityQueue<>(new CustomComparator());
    }

    public boolean book(int start, int end) {
        //System.out.println("================================================");
        Entry eStart = new Entry(start, true);
        Entry eEnd = new Entry(end, false);

        pq.offer(eStart);
        pq.offer(eEnd);

        return !isOverlap(pq, eStart, eEnd);
    }

    private boolean isOverlap(PriorityQueue<Entry> pq, Entry start, Entry end) {
        PriorityQueue<Entry> pcopy = new PriorityQueue<>(pq);
        int bookings = 0;
        boolean overlap = false;
        while(!pcopy.isEmpty()) {
            Entry e = pcopy.poll();
            if(e.start) bookings++;
            else bookings--;
            //System.out.println("entry: "+e+" bookings: "+bookings);
            if(bookings >= 3) overlap = true;
        }
        if(overlap) {
            pq.remove(start);
            pq.remove(end);
        }
        return overlap;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
