package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

class L637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> res = new ArrayList<>();
        int sum = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add((double)sum / size);
            sum = 0;
        }
        return res;
    }
}