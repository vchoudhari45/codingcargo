package com.vc.easy;

import java.util.*;

class MovingAverage {
    /** Initialize your data structure here. */
    List<Integer> list;
    double sum = 0;
    double size = 0;
    public MovingAverage(int size) {
        list = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        list.add(val);
        sum += val;
        if(list.size() <= size) return sum / list.size();
        else {
            sum -= list.remove(0);
            return sum / list.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
