package com.vc.hard;

import java.util.*;

class MyCalendarIii {
    private TreeMap<Integer, Integer> map;
    public MyCalendarIii() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int ongoing = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ongoing += entry.getValue();
            res = Math.max(ongoing, res);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarIii obj = new MyCalendarIii();
 * int param_1 = obj.book(start,end);
 */