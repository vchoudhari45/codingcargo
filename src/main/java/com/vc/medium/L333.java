package com.vc.medium;

import com.vc.hard.TreeNode;

class L333 {

    class Entry {
        int size;
        long leftValue, rightValue;

        Entry(int size, long leftValue, long rightValue) {
            this.size = size;
            this.leftValue = leftValue;
            this.rightValue = rightValue;
        }
    }

    private int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    private Entry helper(TreeNode root) {
        if(root == null) return new Entry(0, Long.MAX_VALUE, Long.MIN_VALUE);
        else {
            Entry left = helper(root.left);
            Entry right = helper(root.right);

            if(left.size != -1 && right.size != -1 &&
                    root.val > left.rightValue && root.val < right.leftValue) {
                int size = left.size + right.size + 1;
                max = Math.max(max, size);
                return new Entry(size,
                        Math.min(root.val, left.leftValue),
                        Math.max(root.val, right.rightValue));
            }

            return new Entry(-1, Long.MAX_VALUE, Long.MIN_VALUE);
        }
    }
}
