package com.vc.hard;


import java.util.*;

class CodecL431 {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;

        TreeNode res = new TreeNode(root.val);
        if(root.children != null && root.children.size() > 0) {
            res.left = encode(root.children.get(0));
            TreeNode current = res.left;
            for(int i = 1; i < root.children.size(); i++) {
                current.right = encode(root.children.get(i));
                current = current.right;
            }
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;

        Node res = new Node(root.val, new ArrayList<Node>());
        TreeNode current = root.left;
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