package com.vc.hard;

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

class RecoverBinarySearchTree {
    private TreeNode prev = null, small = null, large = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = small.val;
        small.val = large.val;
        large.val = temp;
    }

    private void helper(TreeNode root) {
        if(root != null) {
            helper(root.left);
            if(prev != null && prev.val > root.val) {
                if(large == null) large = prev;
                small = root;
            }
            prev = root;
            helper(root.right);
        }
    }
}