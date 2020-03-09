package com.vc.medium;

import com.vc.hard.TreeNode;

class L998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
