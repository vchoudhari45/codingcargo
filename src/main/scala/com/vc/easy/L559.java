package com.vc.easy;


import java.util.List;

class Node559 {
    public int val;
    public List<Node559> children;

    public Node559() {}

    public Node559(int _val, List<Node559> _children) {
        val = _val;
        children = _children;
    }
}

class L559 {
    public int maxDepth(Node559 root) {
        int maxValue = 0;
        if(root != null) {
            for(Node559 node: root.children) {
                maxValue = Math.max(maxValue, maxDepth(node));
            }
            return 1 + maxValue;
        }
        return maxValue;
    }
}