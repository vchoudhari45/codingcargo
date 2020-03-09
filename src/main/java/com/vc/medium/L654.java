package com.vc.medium;

import com.vc.hard.TreeNode;

class L654 {
    private int[] arr;

    public TreeNode constructMaximumBinaryTree(int[] arr) {
        if(arr == null || arr.length == 0) return null;
        this.arr = arr;
        return helper(0, arr.length - 1);
    }

    private TreeNode helper(int from, int to) {
        if(from > to) return null;
        if(from == to) return new TreeNode(arr[from]);

        int maxIndex = getMaxIndex(from, to);
        TreeNode root = new TreeNode(arr[maxIndex]);
        root.left = helper(from, maxIndex - 1);
        root.right = helper(maxIndex + 1, to);
        return root;
    }

    private int getMaxIndex(int from, int to) {
        int maxIndex = from, maxValue = arr[from];
        for(int i = from + 1; i <= to; i++) {
            if(maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
