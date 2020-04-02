package com.vc.easy;

import com.vc.hard.TreeNode;

class L606 {
    private StringBuilder sb;
    public String tree2str(TreeNode t) {
        this.sb = new StringBuilder();
        helper(t);
        return sb.toString();
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        sb.append(root.val);
        if(root.left != null) {
            sb.append("(");
            helper(root.left);
            sb.append(")");
        }

        if(root.right != null) {
            if(root.left == null) sb.append("()");
            sb.append("(");
            helper(root.right);
            sb.append(")");
        }
    }
}
