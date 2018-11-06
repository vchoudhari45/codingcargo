package com.vc.easy;

import java.util.*;

class Node429 {
    public int val;
    public List<Node429> children;

    public Node429() {}

    public Node429(int _val,List<Node429> _children) {
        val = _val;
        children = _children;
    }
};

class L429 {
    public List<List<Integer>> levelOrder(Node429 root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<Node429> q = new LinkedList<Node429>();
        q.add(root);
        q.add(null);
        List<Integer> inner = new ArrayList<Integer>();
        while(!q.isEmpty()) {
            Node429 e = q.remove();
            if(e != null) {
                inner.add(e.val);
                if(e.children != null) q.addAll(e.children);
            }
            else {
                list.add(inner);
                inner = new ArrayList<Integer>();
                if(!q.isEmpty()) q.add(null);
            }
        }
        return list;
    }
}
