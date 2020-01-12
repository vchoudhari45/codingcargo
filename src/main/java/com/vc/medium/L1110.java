package com.vc.medium;

import com.vc.hard.TreeNode;
import java.util.*;

class L1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        HashSet<Integer> toDeleteSet = new HashSet<>();
        for(int i = 0; i < toDelete.length; i++) toDeleteSet.add(toDelete[i]);
        List<TreeNode> res = new ArrayList<>();
        solve(root, true, toDeleteSet, res);
        return res;
    }

    private TreeNode solve(TreeNode root, boolean isRoot, HashSet<Integer> toDeleteSet, List<TreeNode> res) {
        if(root == null) return null;
        boolean isDeleted = toDeleteSet.contains(root.val);
        if(isRoot && !isDeleted) res.add(root);
        root.left = solve(root.left, isDeleted, toDeleteSet, res);
        root.right = solve(root.right, isDeleted, toDeleteSet, res);
        return isDeleted ? null : root;
    }
}
