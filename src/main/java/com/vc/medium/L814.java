package com.vc.medium;

import com.vc.hard.TreeNode;

class L814 {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode parent) {
        if(root == null) return null;

        root.left = helper(root.left, root);
        root.right = helper(root.right, root);

        if(root.left == null && root.right == null) {
            if(root.val == 0) return null;
            else return root;
        }

        return root;
    }
}
