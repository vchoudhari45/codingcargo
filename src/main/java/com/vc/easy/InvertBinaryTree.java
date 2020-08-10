package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *  Problem No: 226
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Amazon, Google, Leetcode, Easy
 *  Title: Invert Binary Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Invert a binary tree. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Invert a binary tree.
 *  Input: s = [4,2,7,1,3,6,9]
 *  Output: [4,7,2,9,6,3,1]
 *****/

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return root;
    }
}
