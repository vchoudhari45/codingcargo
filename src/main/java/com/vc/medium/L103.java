package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        boolean ltr = false;
        q.offer(root);
        q.offer(null);
        Deque<Integer> list = new LinkedList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                if(ltr) list.addFirst(node.val);
                else list.addLast(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            else {
                if(!q.isEmpty()) q.offer(null);
                res.add(new ArrayList<>(list));
                list.clear();
                ltr = !ltr;
            }
        }
        return res;
    }
}
