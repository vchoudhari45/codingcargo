package com.vc.medium;

import com.vc.hard.TreeNode;

class L1120 {
    private double max = 0;
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0d;
        helper(root);
        return max;
    }

    private double[] helper(TreeNode root) {
        if(root == null) return new double[]{0, 0};

        double[] left = helper(root.left);
        double[] right = helper(root.right);

        double sum = left[0] + right[0] + root.val;
        double count = left[1] + right[1] + 1;
        max = Math.max(max, sum / count);

        return new double[]{sum, count};
    }
}
