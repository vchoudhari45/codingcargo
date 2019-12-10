package com.vc.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNodeL449 {
    int val;
    TreeNodeL449 left;
    TreeNodeL449 right;
    TreeNodeL449(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNodeL449 root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNodeL449 root, StringBuilder sb) {
        if(root == null) sb.append("NULL").append(", ");
        else {
            sb.append(root.val).append(", ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNodeL449 deserialize(String data) {
        Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(", ")));
        return deserialize(q);
    }

    public TreeNodeL449 deserialize(Queue<String> q) {
        String s = q.poll();
        if(s.equals("NULL")) return null;
        TreeNodeL449 root = new TreeNodeL449(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));