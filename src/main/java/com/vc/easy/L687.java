package com.vc.easy;

import com.vc.hard.TreeNode;

class L687 {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int leftValue = root.left == null || root.left.val != root.val ? 0 : left;
        int rightValue = root.right == null || root.right.val != root.val ? 0: right;

        max = Math.max(max, leftValue + rightValue);
        return 1 + Math.max(leftValue, rightValue);
    }
}
