package com.vc.hard;

import java.util.*;

class L759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval p1, Interval p2) {
                return Integer.valueOf(p1.start).compareTo(p2.start);
            }
        });

        for(List<Interval> schedule: schedules) {
            for(Interval interval: schedule) {
                pq.offer(interval);
            }
        }

        List<Interval> res = new ArrayList<>();
        Interval prev = pq.poll();
        while(!pq.isEmpty()) {
            if(prev.end < pq.peek().start) {
                res.add(new Interval(prev.end, pq.peek().start));
                prev = pq.poll();
            }
            else {
                prev = prev.end > pq.peek().end ? prev : pq.peek();
                pq.poll();
            }
        }
        return res;
    }
}