package com.vc.easy;

import com.vc.hard.Node;

import java.util.*;

class L589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node current = st.pop();
            res.add(current.val);
            Collections.reverse(current.children);
            for(Node child: current.children) {
                st.push(child);
            }
        }
        return res;
    }
}