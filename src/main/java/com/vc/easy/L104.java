package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

//Recursive
//class L104 {
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
//}

class L104 {
    public int maxDepth(TreeNode root) {
        //Level order traversal
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }
            level++;
        }
        return level;
    }
}
