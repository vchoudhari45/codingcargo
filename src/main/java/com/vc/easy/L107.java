package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

class L107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> inner = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                inner.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            else {
                if(!q.isEmpty()) q.offer(null);
                res.add(0, new ArrayList<>(inner));
                inner.clear();
            }
        }
        return res;
    }
}