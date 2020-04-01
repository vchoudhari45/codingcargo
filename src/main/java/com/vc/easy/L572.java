package com.vc.easy;

import com.vc.hard.TreeNode;

class L572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null ^ t == null) return false;
        if(s == null && t == null) return true;
        return (s.val == t.val && isSame(s, t)) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null ^ t == null) return false;
        if(s == null && t == null) return true;

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
