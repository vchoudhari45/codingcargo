package com.vc.easy;

class TreeNode235 {
    int val;
    TreeNode235 left;
    TreeNode235 right;
    TreeNode235(int x) { val = x; }
}

class L235 {
    public TreeNode235 lowestCommonAncestor(TreeNode235 root, TreeNode235 p, TreeNode235 q) {
        TreeNode235 current = root;
        while(current != null) {
            if(p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            else if(p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            else return current;
        }
        return null;
    }
}
