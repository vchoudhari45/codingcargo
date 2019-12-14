package com.vc.hard;

class L99 {
    TreeNode large = null;
    TreeNode small = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        solve(root);
        int temp = large.val;
        large.val = small.val;
        small.val = temp;
    }

    private void solve(TreeNode root) {
        if(root != null) {
            solve(root.left);
            if(prev != null && prev.val > root.val) {
                if(large == null) large = prev;
                small = root;
            }
            prev = root;
            solve(root.right);
        }
    }
}