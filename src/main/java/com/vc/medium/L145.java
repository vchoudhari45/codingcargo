package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.ArrayList;
import java.util.List;

class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }

    private void solve(TreeNode root, List<Integer> list) {
        if(root != null) {
            solve(root.left, list);
            solve(root.right, list);
            list.add(root.val);
        }
    }
}
