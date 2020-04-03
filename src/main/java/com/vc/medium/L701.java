package com.vc.medium;

import com.vc.hard.TreeNode;

class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root, prev = root;
        while(current != null) {
            if(current.val > val) {
                prev = current;
                current = current.left;
            }
            else if(current.val < val) {
                prev = current;
                current = current.right;
            }
            else return root;
        }

        if(prev.val > val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return root;
    }
}
