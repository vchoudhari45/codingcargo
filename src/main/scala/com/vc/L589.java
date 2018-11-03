package com.vc;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class L589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            for(Node node: root.children) {
                preOrder(node, list);
            }
        }
    }
}
