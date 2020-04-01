package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.Stack;

class L530 {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        int min = Integer.MAX_VALUE;
        Integer prev = null;
        while(!st.isEmpty() || current != null) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(prev != null) {
                    min = Math.min(min, current.val - prev);
                }
                prev = current.val;
                current = current.right;
            }
        }
        return min;
    }
}
