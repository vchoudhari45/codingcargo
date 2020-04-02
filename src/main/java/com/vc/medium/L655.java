package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L655 {
    private List<List<String>> res;

    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        this.res = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < (1 << height) - 1; j++) list.add("");
            this.res.add(list);
        }
        helper(root, 0, 0, (1 << height) - 1);
        return res;
    }

    private void helper(TreeNode root, int level, int lo, int hi) {
        if(root == null) return;
        int mid = lo + (hi - lo) / 2;
        res.get(level).set(mid, String.valueOf(root.val));
        helper(root.left, level + 1, lo, mid - 1);
        helper(root.right, level + 1, mid + 1, hi);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}