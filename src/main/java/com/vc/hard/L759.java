package com.vc.hard;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval(int s, int e) { start = s; end = e; }
}

class L759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        /**
             [1,2],
             [1,3],
             [4,10],
             [5,6]
         */
        List<Interval> result = new ArrayList<Interval>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(e -> pq.addAll(e));

        Interval prev = pq.poll();
        while(!pq.isEmpty()) {
            if(prev.end < pq.peek().start) {
                result.add(new Interval(prev.end, pq.peek().start));
                prev = pq.poll();
            }
            else {
                prev = prev.end > pq.peek().end ? prev : pq.peek();
                pq.poll();
            }
        }
        return result;
    }
}