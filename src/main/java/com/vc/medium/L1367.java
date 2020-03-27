package com.vc.medium;

import com.vc.hard.ListNode;
import com.vc.hard.TreeNode;

class L1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        return head.val == root.val && (helper(head.next, root.left) || helper(head.next, root.right));
    }
}
