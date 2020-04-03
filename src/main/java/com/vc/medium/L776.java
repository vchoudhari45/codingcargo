package com.vc.medium;

import com.vc.hard.TreeNode;

class L776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[2];

        if(root.val > V) {
            TreeNode[] res = splitBST(root.left, V);
            root.left = res[1];
            return new TreeNode[]{res[0], root};
        }
        else {
            TreeNode[] res = splitBST(root.right, V);
            root.right = res[0];
            return new TreeNode[]{root, res[1]};
        }
    }
}
