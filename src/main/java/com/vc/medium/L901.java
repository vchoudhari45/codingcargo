package com.vc.medium;

import java.util.Stack;

class StockSpanner {
    class Node {
        int price = 0;
        int count = 0;

        Node(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    Stack<Node> st;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while(!st.isEmpty() && st.peek().price <= price) count += st.pop().count;
        st.push(new Node(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
