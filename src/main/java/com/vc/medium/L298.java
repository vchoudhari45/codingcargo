package com.vc.medium;

import com.vc.hard.TreeNode;

class L298 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int res = 1;
        if(root.left != null && root.left.val - 1 == root.val) res = 1 + left;
        if(root.right != null && root.right.val - 1 == root.val) res = Math.max(res, 1 + right);

        max = Math.max(max, res);

        return res;
    }
}