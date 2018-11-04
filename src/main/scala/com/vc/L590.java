package com.vc;

import java.util.ArrayList;
import java.util.List;

class Node590 {
    public int val;
    public List<Node590> children;

    public Node590() {}

    public Node590(int _val,List<Node590> _children) {
        val = _val;
        children = _children;
    }
};

class L590 {
    public List<Integer> postorder(Node590 root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node590 root, List<Integer> list){
        if(root != null) {
            for(Node590 node : root.children) {
                postOrder(node, list);
            }
            list.add(root.val);
        }
    }
}
