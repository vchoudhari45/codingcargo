package com.vc.medium;

import java.util.HashMap;

class L666 {
    private HashMap<Integer, Integer> tree;
    private int res = 0;
    public int pathSum(int[] nums) {
        this.tree = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int node = nums[i] / 10;
            int value = nums[i] % 10;
            tree.put(node, value);
        }
        helper(nums[0] / 10, 0);
        return res;
    }

    private void helper(int node, int sum) {
        if(!tree.containsKey(node)) return;

        int depth = node / 10;
        int pos = node % 10;

        int left = (depth + 1) * 10 + (2 * pos - 1);
        int right = left + 1;

        int total = tree.get(node) + sum;

        if(!tree.containsKey(left) && !tree.containsKey(right)) res += total;
        else {
            helper(left, total);
            helper(right, total);
        }
    }
}
