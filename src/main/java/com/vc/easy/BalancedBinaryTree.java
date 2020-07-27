package com.vc.easy;

import com.vc.hard.TreeNode;

/*****
 *  Problem No: 110
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Google, Leetcode, Easy
 *  Title: Balanced Binary Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, determine if it is height-balanced. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *  Input: [3,9,20,null,null,15,7]
 *  Output: true
 *  Input: [1,2,2,3,3,null,null,4,4]
 *  Output: false
 *  Similar Question: Maximum Depth of Binary Tree
 *****/

class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) isBalanced = false;
        return 1 + Math.max(left, right);
    }
}