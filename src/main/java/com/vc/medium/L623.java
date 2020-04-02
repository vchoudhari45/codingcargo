package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(level < d - 1) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            level++;
        }

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }
        return root;
    }
}
