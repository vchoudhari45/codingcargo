package com.vc.easy;

import com.vc.hard.TreeNode;

class L993 {
    private int xDepth = 0, yDepth = 0, x, y;
    private TreeNode xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        helper(root, null, 0);
        return xParent != null && yParent != null && xParent != yParent && xDepth == yDepth;
    }

    private void helper(TreeNode root, TreeNode parent, int depth) {
        if(root == null) return;
        if(root.val == x) {
            xDepth = depth + 1;
            xParent = parent;
        }
        if(root.val == y) {
            yDepth = depth + 1;
            yParent = parent;
        }
        helper(root.left, root, depth + 1);
        helper(root.right, root, depth + 1);
    }
}
