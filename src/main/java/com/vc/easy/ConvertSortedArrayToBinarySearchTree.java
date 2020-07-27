package com.vc.easy;

import com.vc.hard.TreeNode;

/*****
 *  Problem No: 108
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Binary Search Algorithm, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Convert Sorted Array to Binary Search Tree
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array where elements are sorted in ascending order, convert it to a height balanced BST. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *  Input: [-10,-3,0,5,9]
 *  Output: [0,-3,9,-10,null,5]
 *  Similar Question: Convert Sorted List to Binary Search Tree
 *****/

class ConvertSortedArrayToBinarySearchTree {
    /**
     * Binary Search Algorithm
     **/
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if(lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);
        return root;
    }
}
