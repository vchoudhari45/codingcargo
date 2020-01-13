package com.vc.easy;

import com.vc.hard.TreeNode;

class L543 {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        int height = 1 + Math.max(left, right);
        diameter = Math.max(diameter, left + right);
        return height;
    }
}
