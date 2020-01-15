package com.vc.medium;

import java.util.*;

class ExamRoom {

    private int N = 0;
    private PriorityQueue<Interval> pq;

    class Interval {
        int x;
        int y;
        int distance;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
            if(x == -1) this.distance = y;
            else if(y == N) this.distance = N - 1 - x;
            else this.distance = Math.abs(x - y) / 2;
        }
    }

    public ExamRoom(int N) {
        pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                int cmp = Integer.compare(i2.distance, i1.distance);
                if(cmp == 0) return Integer.compare(i1.x, i2.x);
                else return cmp;
            }
        });
        pq.offer(new Interval(-1, N));
        this.N = N;
    }

    public int seat() {
        int seat = 0;
        Interval interval = pq.poll();
        if(interval.x == -1) seat = 0;
        else if(interval.y == N) seat = N - 1;
        else seat = (interval.x + interval.y) / 2;

        pq.offer(new Interval(interval.x, seat));
        pq.offer(new Interval(seat, interval.y));
        return seat;
    }

    public void leave(int p) {
        List<Interval> intervals = new ArrayList<>(pq);
        Interval head = null, tail =null;
        for(Interval interval: intervals) {
            if(interval.x == p) tail = interval;
            if(interval.y == p) head = interval;
        }
        pq.remove(head);
        pq.remove(tail);
        pq.offer(new Interval(head.x, tail.y));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */