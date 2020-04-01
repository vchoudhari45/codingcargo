package com.vc.easy;

import com.vc.hard.TreeNode;

import java.util.HashMap;

class L437 {
    private int res = 0, target;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        this.target = sum;
        map.put(0, 1);
        helper(root, 0, map);
        return res;
    }

    private void helper(TreeNode root, int sum, HashMap<Integer, Integer> map) {
        if(root == null) return;

        int total = sum + root.val;
        if(map.containsKey(total - target)) res += map.get(total - target);

        map.put(total, map.getOrDefault(total, 0) + 1);
        helper(root.left, sum + root.val, map);
        helper(root.right, sum + root.val, map);
        map.put(total, map.get(total) - 1);
    }
}
