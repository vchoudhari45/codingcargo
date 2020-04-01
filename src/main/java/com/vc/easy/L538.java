package com.vc.easy;

import com.vc.hard.TreeNode;

class L538 {
    int res = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        root.val += res;
        res = root.val;
        helper(root.left);
    }
}
