package com.vc.hard;


import java.util.*;

// Definition for a Node.
class Node431 {
    public int val;
    public List<Node431> children;

    public Node431() {}

    public Node431(int _val,List<Node431> _children) {
        val = _val;
        children = _children;
    }
};

class TreeNode431 {
    int val;
    TreeNode431 left;
    TreeNode431 right;
    TreeNode431(int x) { val = x; }
}

class CodecL431 {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode431 encode(Node431 root) {
        if(root == null) return null;

        TreeNode431 res = new TreeNode431(root.val);
        if(root.children != null && root.children.size() > 0) {
            res.left = encode(root.children.get(0));
            TreeNode431 current = res.left;
            for(int i = 1; i < root.children.size(); i++) {
                current.right = encode(root.children.get(i));
                current = current.right;
            }
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node431 decode(TreeNode431 root) {
        if(root == null) return null;

        Node431 res = new Node431(root.val, new ArrayList<Node431>());
        TreeNode431 current = root.left;
        while(current != null) {
            res.children.add(decode(current));
            current = current.right;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));