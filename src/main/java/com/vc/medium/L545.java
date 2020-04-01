package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L545 {
    private List<Integer> left, right;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        this.left = new LinkedList<>();
        this.right = new LinkedList<>();
        if(root == null) return left;
        left.add(root.val);
        if(root.left != null) helperLeft(root.left, true);
        if(root.right != null) helperRight(root.right, true);
        //System.out.println(left);
        //System.out.println(right);
        left.addAll(right);
        return left;
    }

    private void helperLeft(TreeNode root, boolean isEdge) {
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf || isEdge) left.add(root.val);
        if(root.left != null) helperLeft(root.left, isEdge);
        if(root.right != null) helperLeft(root.right, isEdge && root.left == null);
    }

    private void helperRight(TreeNode root, boolean isEdge) {
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf || isEdge) right.add(0, root.val);
        if(root.right != null) helperRight(root.right, isEdge);
        if(root.left != null) helperRight(root.left, isEdge && root.right == null);
    }
}
