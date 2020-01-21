package com.vc.medium;

import com.vc.hard.TreeNode;

class L129 {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int num) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return num * 10 + root.val;
        return sum(root.left, num * 10 + root.val) + sum(root.right, num * 10 + root.val);
    }
}
