package com.vc.easy;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *  Problem No: 225
 *  Category: Data Structures And Algorithms
 *  Tags: Stack, Linked List, Microsoft, Leetcode, Easy
 *  Title: Implement Stack using Queues
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Implement Stack using Queues. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Implement the following operations of a stack using queues. push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element. empty() -- Return whether the stack is empty.
 *  Input: ["MyStack","push","push","top","pop","empty"]
 *  Output: [[],[1],[2],[],[],[]]
 *  Similar Question: Implement Queue using Stacks
 *****/

class MyStack {

    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        for(int i = 0; i < q.size() - 1; i++) {
            q.offer(q.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */