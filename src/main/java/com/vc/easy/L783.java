package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.Stack;

class L783 {
    public int minDiffInBST(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> st =new Stack<>();
        TreeNode prev = null;
        int minDiff = Integer.MAX_VALUE;
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(prev != null) {
                    minDiff = Math.min(minDiff, current.val - prev.val);
                }
                prev = current;
                current = current.right;
            }
        }
        return minDiff;
    }
}
