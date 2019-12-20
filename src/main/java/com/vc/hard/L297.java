package com.vc.hard;

import java.util.*;

class L297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        solve(root, str);
        return str.toString();
    }

    private void solve(TreeNode root, StringBuilder str) {
        if(root != null) {
            str.append(root.val);
            str.append(" ");
            solve(root.left, str);
            solve(root.right, str);
        }
        else {
            str.append("NULL");
            str.append(" ");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        for(String str: data.split(" ")) q.offer(str);
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {
        String val = q.poll();
        if(val.equals("NULL")) {
            return null;
        }
        else {
            TreeNode t = new TreeNode(Integer.parseInt(val));
            t.left = buildTree(q);
            t.right = buildTree(q);
            return t;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
