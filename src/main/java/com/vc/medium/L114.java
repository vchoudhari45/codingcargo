package com.vc.medium;

import com.vc.hard.TreeNode;

class L114 {
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode rightTreeHolder = root.right;

        //Because we know it is already flattened when we invoked flatten(root.left)
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while(current.right != null) current = current.right;
        current.right = rightTreeHolder;
    }
}
