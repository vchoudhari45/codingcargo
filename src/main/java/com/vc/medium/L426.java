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

    private Node first, last;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        solve(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void solve(Node node) {
        if(node == null) return;

        solve(node.left);
        if(last != null) {
            last.right = node;
            node.left = last;
        }
        else {
            first = node;
        }
        last = node;
        solve(node.right);
    }
}