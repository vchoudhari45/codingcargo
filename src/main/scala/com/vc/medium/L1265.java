package com.vc.medium;

import java.util.*;

// This is the ImmutableListNode's API interface.
// You should not implement it, or speculate about its implementation.
interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
};

class L1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> st = new Stack<>();
        ImmutableListNode current = head;
        while(current != null) {
            st.push(current);
            current = current.getNext();
        }

        while(!st.isEmpty()) {
            st.pop().printValue();
        }
    }
}
