package com.vc.medium;

import com.vc.hard.TreeNode;

class L298 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        solve(root);
        return max;
    }

    private int solve(TreeNode root) {
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int lc = 0;
        if(root.left != null && root.left.val - root.val == 1) {
            lc = 1 + left;
        }

        int rc = 0;
        if(root.right != null && root.right.val - root.val == 1) {
            rc = 1 + right;
        }

        //System.out.println("For root: "+root.val+" left: "+lc+" right: "+rc);
        max = Math.max(max, 1 + Math.max(lc, rc));

        return Math.max(lc, rc);
    }
}
