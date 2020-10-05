package com.vc.hard;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class SerializeAndDeserializeNAryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(Node root, StringBuilder sb) {
        if(root == null) {
            sb.append("NULL ");
        }
        else {
            int size = root.children.size();
            sb.append(root.val);
            sb.append(",");
            sb.append(size);
            sb.append(" ");

            for(Node child: root.children) {
                serialize(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] arr = data.split(" ");
        Queue<String> q = new LinkedList<>();
        for(String d: arr) q.offer(d);
        return deserialize(q);
    }

    private Node deserialize(Queue<String> q) {
        String e = q.poll();
        if(e.equals("NULL")) return null;
        else {
            String[] qArr = e.split(",");
            int val = Integer.parseInt(qArr[0]);
            int size = Integer.parseInt(qArr[1]);

            List<Node> children = new ArrayList<>();
            Node node = new Node(val, children);
            for(int i = 0; i < size; i++) {
                children.add(deserialize(q));
            }
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));