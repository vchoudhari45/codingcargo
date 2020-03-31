package com.vc.hard;

import java.util.*;

class L272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> st = new Stack<>();
        Deque<Integer> res = new LinkedList<>();
        TreeNode current = root;
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(res.size() == k) {
                    double diff = Math.abs(res.peekFirst() - target);
                    double currentDiff = Math.abs(current.val - target);
                    if(diff > currentDiff) res.pollFirst();
                    else return new ArrayList<>(res);
                }
                res.add(current.val);
                current = current.right;
            }
        }
        return new ArrayList<>(res);
    }
}