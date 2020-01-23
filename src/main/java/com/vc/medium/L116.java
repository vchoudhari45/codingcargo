package com.vc.medium;

import java.util.*;

class L116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        if(root.left != null) q.offer(root.left);
        if(root.right != null) q.offer(root.right);
        q.offer(null);
        Node prev = null;
        while(!q.isEmpty()) {
            Node e = q.poll();
            if(prev != null) {
                prev.next = e;
            }
            prev = e;
            if(e != null) {
                if(e.left != null) q.offer(e.left);
                if(e.right != null) q.offer(e.right);
            }
            else if(!q.isEmpty()) q.offer(null);
        }
        return root;
    }
}
