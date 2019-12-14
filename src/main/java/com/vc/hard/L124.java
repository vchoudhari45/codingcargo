package com.vc.hard;

class L124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    private int solve(TreeNode root) {
        if(root != null) {
            int left = solve(root.left);
            int right = solve(root.right);

            if(left <= 0 && right <= 0) {
                max = Math.max(max, root.val);
                return root.val;
            }
            else if(left <= 0) {
                max = Math.max(max, right + root.val);
                return root.val + right;
            }
            else if(right <= 0) {
                max = Math.max(max, left + root.val);
                return root.val + left;
            }
            else {
                max = Math.max(max, root.val + left + right);
                return root.val + Math.max(left, right);
            }
        }
        return 0;
    }
}
