package com.vc.easy;

import com.vc.hard.TreeNode;
import java.util.*;

class L872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafRoot1 = new ArrayList<>();
        List<Integer> leafRoot2 = new ArrayList<>();

        getLeaves(root1, leafRoot1);
        getLeaves(root2, leafRoot2);

        if(leafRoot1.size() != leafRoot2.size()) return false;

        for(int i = 0; i < leafRoot1.size(); i++) {
            if(!leafRoot1.get(i).equals(leafRoot2.get(i))) return false;
        }
        return true;
    }

    private void getLeaves(TreeNode root, List<Integer> leafRoot) {
        if(root == null) return;

        if(root.left == null && root.right == null) leafRoot.add(root.val);

        getLeaves(root.left, leafRoot);
        getLeaves(root.right, leafRoot);
    }
}
