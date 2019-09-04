package com.vc.hard;

import java.util.*;

class Node428 {
    public int val;
    public List<Node428> children;

    public Node428() {}

    public Node428(int _val,List<Node428> _children) {
        val = _val;
        children = _children;
    }
};

class Codec {


    // Encodes a tree to a single string.
    public String serialize(Node428 root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder sb, Node428 root) {
        if(root == null) sb.append("#").append(",");
        else {
            sb.append(root.val).append(",");
            sb.append(root.children.size()).append(",");
            for(Node428 node: root.children) {
                serialize(sb, node);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node428 deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    private Node428 deserialize(Queue<String> q) {
        String s = q.poll();
        if(s.equals("#")) return null;

        Node428 root = new Node428(Integer.valueOf(s), new ArrayList<Node428>());
        int children = Integer.valueOf(q.poll());

        root.children = new ArrayList<>();
        for(int i = 0; i < children; i++) {
            root.children.add(deserialize(q));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));