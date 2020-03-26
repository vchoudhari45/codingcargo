package com.vc.medium;


import com.vc.hard.TreeNode;

class L98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        else {
            boolean left = helper(root.left, min, root.val);
            boolean right = helper(root.right, root.val, max);
            return left && right && root.val > min && root.val < max;
        }
    }
}