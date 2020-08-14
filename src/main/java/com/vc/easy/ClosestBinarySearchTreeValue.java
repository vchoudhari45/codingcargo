package com.vc.easy;

import com.vc.hard.TreeNode;

/*****
 *  Problem No: 270
 *  Category: Data Structures And Algorithms
 *  Tags: Binary Search, Tree, Facebook, Leetcode, Easy
 *  Title: Closest Binary Search Tree Value
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *  Input: root = [4,2,5,1,3], target = 3.714286
 *  Output: 4
 *  Similar Question: Count Complete Tree Nodes, Closest Binary Search Tree Value II, Search in a Binary Search Tree
 *****/

class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        int value = -1;

        TreeNode current = root;
        while(current != null) {
            double diff = Math.abs(current.val - target);
            if(diff <= minDiff) {
                minDiff = diff;
                value = current.val;
            }
            if(current.val > target) current = current.left;
            else if(current.val < target) current = current.right;
            else return current.val;
        }
        return value;
    }
}
