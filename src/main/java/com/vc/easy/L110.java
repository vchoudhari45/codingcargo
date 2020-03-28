package com.vc.easy;

import com.vc.hard.TreeNode;

class L110 {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(left - right) > 1) isBalanced = false;

        return 1 + Math.max(left, right);
    }
}