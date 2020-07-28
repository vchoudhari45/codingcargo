package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.Stack;

/*****
 *  Problem No: 112
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Amazon, Leetcode, Easy
 *  Title: Path Sum
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *  Input: Binary Tree = [5,4,8,11,13,4,7,2,null,1], Sum = 22
 *  Output: 5 -> 4 -> 11 -> 2
 *  Similar Question: Path Sum II, Path Sum III, Path Sum IV, Binary Tree Maximum Path Sum, Sum Root to Leaf Numbers
 *****/

class PathSum {
    /**
     * Recursive Approach
     **/
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        else if(root.left == null && root.right == null) return root.val == sum;
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * Non-Recursive Approach
     **/
    public boolean hasPathSumNonRecursive(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node.right == null && node.left == null) if(node.val == sum) return true;
            if(node.right != null) {
                node.right.val += node.val;
                st.push(node.right);
            }
            if(node.left != null) {
                node.left.val += node.val;
                st.push(node.left);
            }
        }
        return false;
    }
}
