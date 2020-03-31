package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class L226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return root;
    }
}
