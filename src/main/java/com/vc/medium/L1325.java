package com.vc.medium;

import com.vc.hard.TreeNode;

class L1325 {

    private int target;
    private TreeNode root;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        this.root = root;
        helper(root, null);
        return this.root;
    }

    private void helper(TreeNode root, TreeNode parent) {
        if(root == null) return;

        helper(root.left, root);
        helper(root.right, root);

        if(root.left == null && root.right == null && root.val == target) {
            if(parent == null) this.root = null;
            else {
                if(parent.left == root) parent.left = null;
                else parent.right = null;
            }
        }
    }
}
