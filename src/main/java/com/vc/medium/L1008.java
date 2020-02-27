package com.vc.medium;

import com.vc.hard.TreeNode;

class L1008 {
    private int index = 0, n = 0;
    private int[] preorder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.n = preorder.length;
        this.preorder = preorder;
        return solve(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode solve(int lower, int higher) {
        if(index == n) return null;

        int val = preorder[index];
        if(val < lower || val > higher) return null;

        index++;
        TreeNode root = new TreeNode(val);
        root.left = solve(lower, val);
        root.right = solve(val, higher);
        return root;
    }
}
