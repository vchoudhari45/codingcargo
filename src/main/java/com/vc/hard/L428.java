package com.vc.hard;

import java.util.*;

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        System.out.println(str.toString());
        return str.toString();
    }

    private void serialize(Node root, StringBuilder str) {
        if(root != null) {
            str.append(root.val);
            str.append(" ");
            if(root.children != null) {
                str.append(root.children.size());
                str.append(" ");
                for(Node node : root.children) {
                    serialize(node, str);
                }
            }
            else str.append("0 ");
        }
        else str.append("NULL ");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        for(String s: data.split(" ")) q.offer(s);
        return deserialize(q);
    }

    private Node deserialize(Queue<String> q) {
        String e = q.poll();
        if(e.equals("NULL")) return null;
        else {
            Node node = new Node(Integer.parseInt(e), new ArrayList<>());
            int size = Integer.parseInt(q.poll());
            List<Node> children = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                children.add(deserialize(q));
            }
            node.children = children;
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));