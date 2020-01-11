package com.vc.medium;

import com.vc.hard.TreeNode;
import java.util.*;

class L1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max = 0;
        int sum = 0;
        q.add(root);
        q.add(null);
        int level = 0;
        int maxLevel = 0;
        while(!q.isEmpty()) {
            TreeNode e = q.poll();
            if(e != null) {
                //System.out.println(q);
                sum += e.val;
                if(e.left != null) q.offer(e.left);
                if(e.right != null) q.offer(e.right);
            }
            else if(!q.isEmpty()) {
                level++;
                if(max < sum) {
                    max = Math.max(sum, max);
                    maxLevel = level;
                }
                sum = 0;
                q.offer(null);
            }
        }
        return maxLevel;
    }
}