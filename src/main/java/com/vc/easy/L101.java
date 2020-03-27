package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

class L101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if(t1 == null ^ t2 == null) return false;
            if(t1 == null && t2 == null) continue;

            if(t1.val != t2.val) return false;

            q.offer(t1.left);
            q.offer(t2.right);
            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }
}
