package com.vc.hard;

import java.util.*;

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

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
        if(left.size() == right.size()) return ((double)left.peek() + (double)right.peek()) / 2.0;
        else return (double)left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
