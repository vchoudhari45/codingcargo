package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

class L257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        this.res = new ArrayList<>();
        if(root == null) return res;
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String path) {
        if(root.left == null && root.right == null) {
            res.add(path + "" +root.val);
        }
        if(root.left != null) helper(root.left, path + root.val+"->");
        if(root.right != null) helper(root.right, path + root.val+"->");
    }
}
