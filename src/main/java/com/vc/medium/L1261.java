package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class FindElements {

    HashSet<Integer> tree = new HashSet<>();

    public FindElements(TreeNode root) {
        if(root != null) {
            tree.add(0);
            solve(root, 0);
        }
    }

    private void solve(TreeNode root, int v) {
        if(root != null) {
            tree.add(v);
            solve(root.left, 2 * v + 1);
            solve(root.right, 2 * v + 2);
        }
    }

    public boolean find(int target) {
        return tree.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
