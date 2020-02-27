package com.vc.medium;


import com.vc.hard.TreeNode;

class L1026 {

    private int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root);
        return res;
    }

    private int[] solve(TreeNode root) { //returns {min, max}
        if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        if(root.left == null && root.right == null) return new int[]{root.val, root.val};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        res = Math.max(res, Math.abs(min - root.val));
        res = Math.max(res, Math.abs(max - root.val));

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        return new int[]{min, max};
    }
}
