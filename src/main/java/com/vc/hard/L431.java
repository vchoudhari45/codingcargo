package com.vc.hard;

import java.util.*;

class L431 {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        else {
            TreeNode tree = new TreeNode(root.val);
            if(root.children != null && root.children.size() > 0) {
                tree.left = encode(root.children.get(0));
                TreeNode current = tree.left;
                for(int i = 1; i < root.children.size(); i++) {
                    current.right = encode(root.children.get(i));
                    current = current.right;
                }
            }
            return tree;
        }
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root != null) {
            Node node = new Node(root.val, new ArrayList<Node>());
            TreeNode current = root.left;
            while(current != null) {
                node.children.add(decode(current));
                current = current.right;
            }
            return node;
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));