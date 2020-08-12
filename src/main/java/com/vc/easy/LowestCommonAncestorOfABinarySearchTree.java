package com.vc.easy;

import com.vc.hard.TreeNode;

/*****
 *  Problem No: 235
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Lowest Common Ancestor of a Binary Search Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. Lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants.
 *  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *  Output: 2
 *  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *  Output: 6
 *  Similar Question: Lowest Common Ancestor of a Binary Tree, Smallest Common Region
 *****/

class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(current != null) {
            if(current.val > p.val && current.val > q.val) current = current.left;
            else if(current.val < p.val && current.val < q.val) current = current.right;
            else return current;
        }
        return null;
    }
}
