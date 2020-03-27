package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.HashMap;

class L105 {
    private HashMap<Integer, Integer> inorderLookup;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
             preorder: [3, 9, 20, 15, 7]
             inorder:  [9, 3, 15, 20, 7]
                        0  1   2   3  4
         */
        this.inorderLookup = new HashMap<>();
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) inorderLookup.put(inorder[i], i);
        return helper(0, preorder.length - 1, 0,  inorder.length - 1);
    }

    private TreeNode helper(int pl, int ph, int il, int ih) {
        if(pl > ph) return null;

        int rootValue = preorder[pl];
        int rootIndex = inorderLookup.get(rootValue);
        int leftCount = rootIndex - il;

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(pl + 1, pl + leftCount, il, rootIndex - 1);
        root.right = helper(pl + leftCount + 1, ph, rootIndex + 1, ih);
        return root;
    }
}