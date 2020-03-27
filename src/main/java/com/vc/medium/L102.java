package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

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
                res.add(new ArrayList<>(inner));
                inner.clear();
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return res;
    }
}
