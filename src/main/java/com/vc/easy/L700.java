package com.vc.easy;

import com.vc.hard.TreeNode;

class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current != null) {
            if(current.val > val) current = current.left;
            else if(current.val < val) current = current.right;
            else return current;
        }
        return null;
    }
}
