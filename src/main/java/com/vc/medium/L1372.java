package com.vc.medium;

import com.vc.hard.TreeNode;

class L1372 {
    static class Count {
        int leftCount;
        int rightCount;

        Count(int leftCount, int rightCount) {
            this.leftCount = leftCount;
            this.rightCount = rightCount;
        }
    }

    private int max = 0;
    public int longestZigZag(TreeNode root) {
        helper(root);
        return max;
    }

    private Count helper(TreeNode root) {
        if(root == null) return new Count(0, 0);

        Count left = helper(root.left);
        Count right = helper(root.right);

        Count r = new Count(0, 0);
        if(root.left != null) r.leftCount = left.rightCount + 1;
        if(root.right != null) r.rightCount = right.leftCount + 1;

        max = Math.max(max, r.leftCount);
        max = Math.max(max, r.rightCount);

        return r;
    }
}
