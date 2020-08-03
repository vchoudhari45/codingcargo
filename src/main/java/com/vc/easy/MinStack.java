package com.vc.easy;

import java.util.Stack;

/*****
 *  Problem No: 155
 *  Category: Data Structures And Algorithms
 *  Tags: Stack, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Min Stack
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. It is an easy problem that uses Stack Data Structure to solve the problem.
 *  Description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element. getMin() -- Retrieve the minimum element in the stack.
 *  Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *  Output: [[],[-2],[0],[-3],[],[],[],[]]
 *  Similar Question: Max Stack, Sliding Window Maximum
 *****/

class MinStack {

    private Stack<int[]> st;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if(st.isEmpty()) st.push(new int[]{x, x});
        else st.push(new int[]{x, Math.min(st.peek()[1], x)});
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}

