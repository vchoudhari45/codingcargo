package com.vc.medium;

import com.vc.hard.TreeNode;

class L250 {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        if(root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if(left && right
                && (root.right == null || root.right.val == root.val)
                && (root.left == null || root.left.val == root.val)) {
            res++;
            return true;
        }
        return false;
    }
}