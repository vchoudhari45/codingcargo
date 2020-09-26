package com.vc.hard;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ClosestBinarySearchTreeValueIi {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> res = new LinkedList<>();

        TreeNode current = root;
        Stack<TreeNode> st = new Stack<>();
        while(current != null || !st.isEmpty()) {
            if(current != null) {
                st.push(current);
                current = current.left;
            }
            else {
                current = st.pop();
                if(res.size() == k) {
                    double diff = Math.abs(target - res.peekFirst());
                    double currentDiff = Math.abs(target - current.val);
                    if(currentDiff < diff) res.pollFirst();
                    else return new ArrayList<>(res);
                }
                res.add(current.val);
                current = current.right;
            }
        }
        return new ArrayList<>(res);
    }
}