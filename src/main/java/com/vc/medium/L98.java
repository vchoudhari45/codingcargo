package com.vc.medium;


import com.vc.hard.TreeNode;

class L98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer lo, Integer hi) {
        if(root == null) return true;
        if(lo != null && root.val <= lo) return false;
        if(hi != null && root.val >= hi) return false;
        return isValid(root.left, lo, root.val) && isValid(root.right, root.val, hi);
    }
}