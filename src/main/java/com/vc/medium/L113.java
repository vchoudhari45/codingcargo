package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L113 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res = new ArrayList<>();
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> current) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                current.add(root.val);
                res.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
        }

        current.add(root.val);
        helper(root.left, sum - root.val, current);
        helper(root.right, sum - root.val, current);
        current.remove(current.size() - 1);
    }
}
