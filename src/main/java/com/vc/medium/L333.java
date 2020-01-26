package com.vc.medium;

import com.vc.hard.TreeNode;

class L333 {
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        solve(root);
        return max;
    }

    private int[] solve(TreeNode root) {
        if(root == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        if(left[0] == -1 || right[0] == -1 || root.val <= left[2] || root.val >= right[1]) {
            return new int[]{-1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int size = left[0] + 1 + right[0];
        max = Math.max(max, size);
        return new int[]{size, Math.min(left[1], root.val), Math.max(right[2], root.val)};
    }
}
