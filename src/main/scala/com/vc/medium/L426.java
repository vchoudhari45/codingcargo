package com.vc.medium;

import java.util.Stack;

class Node426 {
    public int val;
    public Node426 left;
    public Node426 right;

    public Node426() {}

    public Node426(int _val,Node426 _left,Node426 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class L426 {
    public Node426 treeToDoublyList(Node426 root) {
        if(root == null) return null;
        Node426 dummyNode = new Node426();
        Node426 prev = dummyNode;
        Node426 current = root;
        Stack<Node426> st = new Stack<Node426>();
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                prev.right = current;
                current.left = prev;
                prev = current;
                current = current.right;
            }
        }
        prev.right = dummyNode.right;
        dummyNode.right.left = prev;
        return dummyNode.right;
    }
}
