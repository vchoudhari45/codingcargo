package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L652 {
    HashMap<String, Integer> tree = new HashMap<String, Integer>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return res;
    }

    private String postOrder(TreeNode root) {
        if(root == null) return "NULL";
        String left = postOrder(root.left);
        String right = postOrder(root.right);
        String key = root.val +"->"+left+"->"+right;
        if(!tree.containsKey(key)) tree.put(key, 1);
        else if(tree.get(key) == 1) {
            tree.put(key, 2);
            res.add(root);
        }
        return key;
    }
}
