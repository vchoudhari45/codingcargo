package com.vc.medium;

import com.vc.hard.TreeNode;

class L106 {

    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;

        this.inorder = inorder;
        this.postorder = postorder;

        int n = inorder.length;
        return helper(0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int il, int ir, int pl, int pr) {
        if(il > ir) return null;
        else if(il == ir) return new TreeNode(postorder[pr]);
        else {
            TreeNode root = new TreeNode(postorder[pr]);

            int index = -1;
            for(int i = il; i <= ir; i++) {
                if(inorder[i] == postorder[pr]) {
                    index = i;
                    break;
                }
            }

            int leftCount = index - il;
            int rightCount = ir - index;

            root.left = helper(il, index - 1, pl, pl + leftCount - 1);
            root.right = helper(index + 1, ir, pr - rightCount, pr - 1);

            return root;
        }
    }
}
