package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.*;

class L501 {
    private int maxCount = 0, currentCount = 1;
    private List<Integer> modes;
    private Integer prev;
    public int[] findMode(TreeNode root) {
        this.modes = new ArrayList<>();
        inorder(root);
        int[] res = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++) res[i] = modes.get(i);
        return res;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null) {
            if(prev == root.val) currentCount++;
            else currentCount = 1;
        }
        if(currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            currentCount = maxCount;
            modes.add(root.val);
        }
        else if(currentCount == maxCount) modes.add(root.val);
        prev = root.val;
        inorder(root.right);
    }
}
