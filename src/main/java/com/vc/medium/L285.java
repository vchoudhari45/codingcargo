package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.Stack;

class L285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root, prev = null;
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(prev != null && prev == p) {
                    return current;
                }
                prev = current;
                current = current.right;
            }
        }
        return null;
    }
}
