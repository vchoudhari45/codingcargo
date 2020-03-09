package com.vc.medium;


import com.vc.hard.TreeNode;

class L1315 {
    private int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode parent, TreeNode gParent) {
        if(root == null) return;

        if(gParent != null && gParent.val % 2 == 0) {
            res += root.val;
        }
        helper(root.left, root, parent);
        helper(root.right, root, parent);
    }
}
