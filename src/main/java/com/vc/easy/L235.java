package com.vc.easy;

import com.vc.hard.TreeNode;

class L235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(current != null) {
            if(current.val > p.val && current.val > q.val) current = current.left;
            else if(current.val < p.val && current.val < q.val) current = current.right;
            else return current;
        }
        return null;
    }
}
