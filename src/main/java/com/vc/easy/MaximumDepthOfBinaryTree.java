package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *  Problem No: 104
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Level Order Traversal, Amazon, Google, Microsoft, Leetcode, Easy
 *  Title: Maximum Depth Of Binary Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, find its maximum depth. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *  Input: [3,9,20,null,null,15,7]
 *  Output: 3
 *  Similar Question: Balanced Binary Tree, Minimum Depth of Binary Tree, Maximum Depth of N-ary Tree, Time Needed to Inform All Employees
 *****/

class MaximumDepthOfBinaryTree {
    /**
     *  Recursive Approach
     **/
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     *  Non-Recursive Approach: Level Order Traversal
     **/
    public int maxDepthNonRecursive(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }
            height++;
        }
        return height;
    }
}
