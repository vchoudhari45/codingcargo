package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L663 {
    private Stack<Integer> st;
    public boolean checkEqualTree(TreeNode root) {
        this.st = new Stack<>();
        int total = sum(root);
        st.pop();
        if(total % 2 == 0) {
            while(!st.isEmpty()) {
                if(st.pop() == total / 2) return true;
            }
        }
        return false;
    }

    private int sum(TreeNode root) {
        if(root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        st.push(left + right + root.val);
        return st.peek();
    }
}
