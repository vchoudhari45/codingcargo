package com.vc.hard;

import java.util.*;

class DinnerPlates {

    Map<Integer, Stack<Integer>> map;
    int cap;
    int pushAt;
    int popFrom;
    int count;

    public DinnerPlates(int capacity) {
        map = new HashMap<Integer, Stack<Integer>>();
        cap = capacity;
        pushAt = 0;
        popFrom = 0;
        map.put(pushAt, new Stack<Integer>());
    }

    public void push(int val) {
        while(map.containsKey(pushAt) && map.get(pushAt).size() == cap) {
            pushAt++;
        }
        if(!map.containsKey(pushAt)) {
            map.put(pushAt, new Stack<Integer>());
        }
        map.get(pushAt).push(val);
        popFrom = Math.max(popFrom, pushAt);
        count++;
    }

    public int pop() {
        if(count == 0) return -1;
        while(popFrom >= 0 && map.get(popFrom).isEmpty()) {
            popFrom--;
        }
        count--;
        return map.get(popFrom).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index) || map.get(index).isEmpty()) return -1;
        count--;
        pushAt = Math.min(pushAt, index);
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
