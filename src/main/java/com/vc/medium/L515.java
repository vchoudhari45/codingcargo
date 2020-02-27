package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        q.offer(root);
        q.offer(null);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            TreeNode e = q.poll();
            if(e != null) {
                max = Math.max(max, e.val);
                if(e.left != null) q.offer(e.left);
                if(e.right != null) q.offer(e.right);
            }
            else {
                res.add(max);
                max = Integer.MIN_VALUE;
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return res;
    }
}
