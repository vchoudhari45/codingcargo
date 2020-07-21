package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

/*****
 *  Problem No: 107
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Level Order Traversal, Amazon, Leetcode, Easy
 *  Title: Binary Tree Level Order Traversal II
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, return the bottom-up level order traversal of its nodes' values. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *  Input: [3,9,20,null,null,15,7]
 *  Output: [[15,7], [9,20], [3]]
 *  Similar Question: Binary Tree Level Order Traversal, Average of Levels in Binary Tree
 *****/

class BinaryTreeLevelOrderTraversalII {
    /**
     *  Level Order Traversal
     **/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }
            res.add(0, list);
        }

        return res;
    }
}