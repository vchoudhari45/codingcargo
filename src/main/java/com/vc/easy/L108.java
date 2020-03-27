package com.vc.easy;

import com.vc.hard.TreeNode;

class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if(lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);
        return root;
    }
}
