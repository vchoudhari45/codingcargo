package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L230 {
    private List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        this.list = new ArrayList<>();
        inorder(root);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
