package com.vc.medium;

import com.vc.hard.TreeNode;

class L222 {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if(leftDepth == rightDepth) return (1 << leftDepth) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while(root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while(root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }
}
