package com.vc.medium;

import com.vc.hard.TreeNode;

class L1145 {
    int left = 0;
    int right = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);

        // if player2 chooses player1's parent node and payer1 node's count is smaller than n/2, playr2 will win
        if((left + right + 1) * 2 < n) return true;

        // if player2 chooses player1's left or right node and its count is bigger than n/2, playr2 will win
        if(2 * left > n  || 2 * right > n) return true;

        return false;
    }

    private int count(TreeNode root, int x) {
        if(root == null) return 0;
        int l = count(root.left, x);
        int r = count(root.right, x);
        if(root.val == x) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
