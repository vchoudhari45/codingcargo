package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L655 {
    private String[][] res;

    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        this.res = new String[height][(1 << height) - 1];
        for(int i = 0; i < res.length; i++) Arrays.fill(res[i], "");
        List<List<String>> ans = new ArrayList<>();
        for(String[] arr: res) ans.add(Arrays.asList(arr));
        helper(root, 0, 0, (1 << height) - 1);
        return ans;
    }

    private void helper(TreeNode root, int level, int lo, int hi) {
        if(root == null) return;
        int mid = lo + (hi - lo) / 2;
        res[level][mid] = String.valueOf(root.val);
        helper(root.left, level + 1, lo, mid - 1);
        helper(root.right, level + 1, mid + 1, hi);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
