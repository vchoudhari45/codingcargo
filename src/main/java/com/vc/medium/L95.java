package com.vc.medium;

import java.util.*;
import com.vc.hard.TreeNode;

class L95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return solve(1, n);
    }

    private List<TreeNode> solve(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if(lo > hi) res.add(null);
        for(int index = lo; index <= hi; index++) {
            List<TreeNode> left = solve(lo, index - 1);
            List<TreeNode> right = solve(index + 1, hi);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode root = new TreeNode(index);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
