package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L366 {
    private List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.res = new ArrayList<>();
        height(root);
        return res;
    }

    private int height(TreeNode root) {
        if(root == null) return -1;
        int level = 1 + Math.max(height(root.left), height(root.right));
        if(res.size() < level + 1) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
}
