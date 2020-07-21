package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *  Problem No: 101
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Symmetric Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center). It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *  Input: [1,2,2,3,4,4,3]
 *  Output: true
 *  Input: [1,2,2,null,3,null,3]
 *  Output: false
 *****/

class SymmetricTree {
    /**
     * Recursive Approach
     **/
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        else if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }


    /**
     * Non-Recursive Approach
     **/
    public boolean isSymmetricNonRecursive(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q.offer(t1.left);
            q.offer(t2.right);

            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }
}