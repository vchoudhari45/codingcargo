package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode e = q.poll();
                if(i == size - 1) res.add(e.val);
                if(e.left != null) q.offer(e.left);
                if(e.right != null) q.offer(e.right);
            }
        }
        return res;
    }
}
