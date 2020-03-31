package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(!st.isEmpty() || current != null) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(--k == 0) return current.val;
                current = current.right;
            }
        }
        return -1;
    }
}
