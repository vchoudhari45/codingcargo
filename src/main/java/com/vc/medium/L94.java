package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> st = new Stack<>();
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}
