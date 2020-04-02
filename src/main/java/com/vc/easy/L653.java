package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.HashSet;

class L653 {
    private HashSet<Integer> prefix;
    private int target = 0;
    public boolean findTarget(TreeNode root, int k) {
        this.prefix = new HashSet<>();
        this.target = k;
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if(root == null) return false;
        if(prefix.contains(target - root.val)) return true;
        prefix.add(root.val);
        return helper(root.left) || helper(root.right);
    }
}
