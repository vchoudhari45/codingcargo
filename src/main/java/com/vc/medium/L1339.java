package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L1339 {
    List<Long> sum = new ArrayList<>();
    int MOD = (int)1e9 + 7;
    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
        long max = 0;
        for(Long s: sum)
            max = Math.max(max, (totalSum - s) * s);
        return (int)(max % MOD);
    }

    private long sum(TreeNode root) {
        if(root == null) return 0;
        long left = sum(root.left);
        long right = sum(root.right);
        sum.add(left + right + root.val);
        return left + right + root.val;
    }
}
