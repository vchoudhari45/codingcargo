package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

/*****
 *  Problem No: 257
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Facebook, Leetcode, Easy
 *  Title: Binary Tree Paths
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree, return all root-to-leaf paths. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree, return all root-to-leaf paths.
 *  Input: [1,2,3,null,5]
 *  Output: ["1->2->5","1->3"]
 *  Similar Question: Path Sum II, Smallest String Starting From Leaf
 *****/

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        if(root == null) return list;
        helper(root, "", list);
        return list;
    }

    private void helper(TreeNode root, String path, List<String> list) {
        if(root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        if(root.left != null) helper(root.left, path + root.val + "->", list);
        if(root.right != null) helper(root.right, path + root.val + "->", list);
    }
}