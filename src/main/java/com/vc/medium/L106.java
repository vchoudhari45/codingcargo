package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.HashMap;

class L106 {
    private int[] postorder;
    private HashMap<Integer, Integer> inorderLookup;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
             inorder   = [9,3,15,20,7]
             postorder = [9,15,7,20,3]
                          0  1 2  3 4
         */
        this.postorder = postorder;
        this.inorderLookup = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) inorderLookup.put(inorder[i], i);
        return helper(0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int il, int ih, int pl, int ph) {
        if(pl > ph) return null;

        int rootValue = postorder[ph];
        int rootIndex = inorderLookup.get(rootValue);
        int leftCount = rootIndex - il;
        int rightCount = ih - rootIndex;

        TreeNode root = new TreeNode(rootValue);

        root.left = helper(il, rootIndex - 1, pl, pl + leftCount - 1);
        root.right = helper(rootIndex + 1, ih, ph - rightCount, ph - 1);

        return root;
    }
}