package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class L971 {
    private List<Integer> res;
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        this.res = new ArrayList<>();
        return preorder(root, v) ? res : Arrays.asList(-1);
    }

    private boolean preorder(TreeNode root, int[] v) {
        if(root == null) return true;
        if(root.val != v[index++]) return false;
        if(root.left != null && root.left.val != v[index]) {
            res.add(root.val);
            return preorder(root.right, v) && preorder(root.left, v);
        }
        return preorder(root.left, v) && preorder(root.right, v);
    }
}
