package com.vc.hard;

import java.util.*;

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer p, Integer q) {
                return Integer.compare(q, p);
            }
        });
        right = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer p, Integer q) {
                return Integer.compare(p, q);
            }
        });
    }

    public void addNum(int num) {
        if(left.size() <= right.size()) {
            right.offer(num);
            left.offer(right.poll());
        }
        else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) return (double)(left.peek() + right.peek()) / 2;
        else return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */