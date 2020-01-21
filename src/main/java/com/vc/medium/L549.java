package com.vc.medium;

import com.vc.hard.TreeNode;

class L549 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        solve(root);
        return max;
    }

    private int[] solve(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int increment = 1, decrement = 1;
        if(root.left != null) {
            int[] l = solve(root.left);
            if(root.val == root.left.val + 1) {
                decrement = l[0] + 1;
            }
            if(root.val == root.left.val - 1) {
                increment = l[1] + 1;
            }
        }
        if(root.right != null) {
            int[] r = solve(root.right);
            if(root.val == root.right.val + 1) {
                decrement = Math.max(decrement, r[0] + 1);
            }
            if(root.val == root.right.val - 1) {
                increment = Math.max(increment, r[1] + 1);
            }
        }
        max = Math.max(max, increment + decrement - 1);
        return new int[]{decrement, increment};
    }
}
