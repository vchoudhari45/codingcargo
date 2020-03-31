package com.vc.medium;

class L426 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node head, tail;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        helper(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void helper(Node root) {
        if(root == null) return;

        helper(root.left);
        if(head == null) head = root;
        if(tail != null) {
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        helper(root.right);
    }
}