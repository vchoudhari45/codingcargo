package com.vc.hard;

class TreeNodeL99 {
    int val;
    TreeNodeL99 left;
    TreeNodeL99 right;
    TreeNodeL99(int x) { val = x; }
}

class L99 {
    TreeNodeL99 large = null;
    TreeNodeL99 small = null;
    TreeNodeL99 prev = null;
    public void recoverTree(TreeNodeL99 root) {
        solve(root);
        int temp = large.val;
        large.val = small.val;
        small.val = temp;
    }

    private void solve(TreeNodeL99 root) {
        if(root != null) {
            solve(root.left);
            if(prev != null && prev.val > root.val) {
                if(large == null) large = prev;
                small = root;
            }
            prev = root;
            solve(root.right);
        }
    }
}