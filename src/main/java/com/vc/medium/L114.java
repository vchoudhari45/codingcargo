package com.vc.medium;

import com.vc.hard.TreeNode;

class L114 {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if(root == null) return null;

        if(root.left == null && root.right == null) return root;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if(left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right == null ? left : right;
    }
}