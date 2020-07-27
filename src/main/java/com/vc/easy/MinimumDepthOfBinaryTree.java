package com.vc.easy;

import com.vc.hard.TreeNode;

/*****
 *  Problem No: 111
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Facebook, Leetcode, Easy
 *  Title: Minimum Depth of Binary Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, find its minimum depth. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *  Input: [3,9,20,null,null,15,7]
 *  Output: 2
 *  Input: [1,2]
 *  Output: 2
 *  Similar Question: Binary Tree Level Order Traversal, Maximum Depth of Binary Tree
 *****/

class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return left == 0 || right == 0 ? 1 + left + right : 1 + Math.min(left, right);
    }
}
