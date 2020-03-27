package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                res.add(current.val);
                st.push(current);
                current = current.left;
            }
            else current = st.pop().right;
        }
        return res;
    }
}
