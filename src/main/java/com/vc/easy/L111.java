package com.vc.easy;

import com.vc.hard.TreeNode;

class L111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null) return 1 + minDepth(root.right);
        else if(root.right == null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
