package com.vc.easy;

import com.vc.hard.TreeNode;

class L270 {
    public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        int value = -1;

        TreeNode current = root;
        while(current != null) {
            double diff = Math.abs(target - current.val);
            if(minDiff > diff) {
                minDiff = diff;
                value = current.val;
            }
            if(current.val > target) current = current.left;
            else if(current.val < target) current = current.right;
            else return current.val;
        }
        return value;
    }
}
