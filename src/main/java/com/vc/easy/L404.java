package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.Stack;

class L404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
                if(current != null && current.left == null && current.right == null) {
                    res += current.val;
                }
            }
            else current = st.pop().right;
        }
        return res;
    }
}