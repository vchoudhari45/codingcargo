package com.vc.medium;

import com.vc.hard.TreeNode;

class L1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;

        int height = height(root);

        return sum(root, height);
    }

    private int sum(TreeNode root, int height) {
        if(root == null) return 0;
        else if(height == 1) return root.val;
        else return sum(root.left, height - 1) + sum(root.right, height - 1);
    }

    private int height(TreeNode root) {
        if(root != null) {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
        return 0;
    }
}
