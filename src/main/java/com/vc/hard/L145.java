package com.vc.hard;

import java.util.*;

class TreeNode145 {
    int val;
    TreeNode145 left;
    TreeNode145 right;
    TreeNode145(int x) { val = x; }
}

class L145 {
    public List<Integer> postorderTraversal(TreeNode145 root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }

    private void solve(TreeNode145 root, List<Integer> list) {
        if(root != null) {
            solve(root.left, list);
            solve(root.right, list);
            list.add(root.val);
        }
    }
}
