package com.vc.easy;

import com.vc.hard.TreeNode;

class L111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int minDepth = Integer.MAX_VALUE;
        if(root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }

        if(root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }

        return 1 + (minDepth == Integer.MAX_VALUE ? 0 : minDepth);
    }
}
