package com.vc.medium;

import java.util.TreeMap;

class MyCalendar {

    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = treeMap.floorKey(start);
        if(prev != null && treeMap.get(prev) > start) return false;

        Integer next = treeMap.lowerKey(end);
        if(next != null && next >= start) return false;

        treeMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
