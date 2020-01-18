package com.vc.easy;


import com.vc.hard.TreeNode;

class L965 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        else return solve(root, root.val);
    }

    private boolean solve(TreeNode root, int value) {
        if(root == null) return true;
        if(root.val != value) return false;
        else return solve(root.left, value) & solve(root.right, value);
    }
}
