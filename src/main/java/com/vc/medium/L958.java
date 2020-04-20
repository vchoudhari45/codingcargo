package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) end = true;
            else {
                if(end) return false;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
}
