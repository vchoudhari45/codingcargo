package com.vc.medium;

import com.vc.hard.TreeNode;

class L979 {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        solve(root);
        return moves;
    }

    private int solve(TreeNode root) {
        if(root != null) {
            int left = solve(root.left);
            int right = solve(root.right);
            moves += Math.abs(left) + Math.abs(right);
            root.val += left + right;
            return root.val - 1;
        }
        return 0;
    }
}
