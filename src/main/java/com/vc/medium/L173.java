package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();

        TreeNode current = root;
        while(current != null) {
            st.push(current);
            current = current.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = st.pop();
        TreeNode current = res.right;
        while(current != null) {
            st.push(current);
            current = current.left;
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
