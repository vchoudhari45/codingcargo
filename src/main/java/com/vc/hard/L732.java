package com.vc.hard;

import java.util.*;

class MyCalendarThree {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int ongoing = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ongoing += entry.getValue();
            res = Math.max(res, ongoing);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */