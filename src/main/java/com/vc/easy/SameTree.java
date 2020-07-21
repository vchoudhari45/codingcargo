package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *  Problem No: 100
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Level Order Traversal, Amazon, Leetcode, Easy
 *  Title: Same Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given two binary trees, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical and the nodes have the same value. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given two binary trees, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *  Input: [1,2,3], [1,2,3]
 *  Output: true
 *  Input: [1,2], [1,null,2]
 *  Output: false
 *****/

class SameTree {
    /**
     * Recursive Approach
     **/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ^ q == null) return false;
        if(p == null) return true;
        else return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Non-Recursive Approach
     **/
    public boolean isSameTreeNonRecursive(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()) {
            TreeNode pn = queue.poll();
            TreeNode qn = queue.poll();
            if(pn == null && qn == null) continue;
            else if(pn == null || qn == null || pn.val != qn.val) return false;
            queue.offer(pn.left);
            queue.offer(qn.left);
            queue.offer(pn.right);
            queue.offer(qn.right);
        }
        return true;
    }
}

