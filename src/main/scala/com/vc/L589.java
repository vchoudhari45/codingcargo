package com.vc;

import java.util.ArrayList;
import java.util.List;

class Node589 {
    public int val;
    public List<Node589> children;

    public Node589() {}

    public Node589(int _val,List<Node589> _children) {
        val = _val;
        children = _children;
    }
}

class L589 {
    public List<Integer> preorder(Node589 root) {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node589 root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            for(Node589 node: root.children) {
                preOrder(node, list);
            }
        }
    }
}
