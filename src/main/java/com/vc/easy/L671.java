package com.vc.easy;

import com.vc.hard.TreeNode;

class L671 {
    private long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return min2 == Long.MAX_VALUE ? -1 : (int)min2;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        if(min1 > root.val) min1 = root.val;
        else if(min2 > root.val && min1 != root.val) min2 = root.val;

        helper(root.left);
        helper(root.right);
    }
}
