package com.vc.medium;

import com.vc.hard.TreeNode;

class L105 {

    private int[] preorder, inorder;
    private int n;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.n = preorder.length;
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int pl, int pr, int il, int ir) {
        if(pl > pr) return null;
        else if(pl == pr) return new TreeNode(preorder[pl]);
        else {
            TreeNode root = new TreeNode(preorder[pl]);
            int index = 0;
            for(int i = il; i <= ir; i++) {
                if(inorder[i] == preorder[pl]) {
                    index = i;
                    break;
                }
            }

            int leftCount = index - il;
            int rightCount = ir - index;

            root.left = helper(pl + 1, pl + leftCount, il, index - 1);
            root.right = helper(pr - rightCount + 1, pr, index + 1, ir);

            return root;
        }
    }
}
