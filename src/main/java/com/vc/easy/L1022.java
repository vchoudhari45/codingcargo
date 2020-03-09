package com.vc.easy;

import com.vc.hard.TreeNode;

class L1022 {
    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int num) {
        num += root.val;
        if(root.left == null && root.right == null) res += num;
        if(root.left != null) helper(root.left, num << 1);
        if(root.right != null) helper(root.right, num << 1);
    }
}
