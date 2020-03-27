package com.vc.medium;

import com.vc.hard.TreeNode;

class L1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
                                        final TreeNode target) {
        if(original == target) return cloned;
        if(original == null) return null;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) return left;

        return getTargetCopy(original.right, cloned.right, target);
    }
}
