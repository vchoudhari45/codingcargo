package com.vc.hard;

import java.util.*;

class FreqStack {

    HashMap<Integer, Integer> count = new HashMap<>();
    HashMap<Integer, Stack<Integer>> value = new HashMap<>();
    int maxCount = 0;

    public FreqStack() {

    }

    public void push(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);

        int newCount = count.get(x);

        maxCount = Math.max(maxCount, newCount);

        Stack<Integer> st = value.getOrDefault(newCount, new Stack<Integer>());
        st.push(x);

        value.put(newCount, st);
    }

    public int pop() {
        Stack<Integer> st = value.get(maxCount);
        int res = st.pop();
        count.put(res, maxCount - 1);
        if(st.isEmpty()) maxCount--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
