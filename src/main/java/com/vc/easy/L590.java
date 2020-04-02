package com.vc.easy;

import com.vc.hard.Node;

import java.util.*;

class L590 {
    private List<Integer> res;
    public List<Integer> postorder(Node root) {
        this.res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(Node root) {
        if(root == null) return;
        if(root.children != null) {
            for(Node child: root.children) {
                helper(child);
            }
        }
        res.add(root.val);
    }
}