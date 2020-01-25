package com.vc.medium;

import java.util.*;

class L117 {
    class Node {
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
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        Node prev = null;
        if(root.left != null) q.offer(root.left);
        if(root.right != null) q.offer(root.right);
        q.offer(null);
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(prev != null) {
                prev.next = current;
            }
            prev = current;
            if(current != null) {
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            else if(!q.isEmpty()) {
                q.offer(null);
            }
        }
        return root;
    }
}
