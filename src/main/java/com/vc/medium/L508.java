package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L508 {
    private HashMap<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        this.map = new HashMap<>();
        helper(root);

        int maxCount = 0;
        List<Integer> max = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int sum = entry.getKey();
            int sumCount = entry.getValue();
            if(sumCount > maxCount) {
                maxCount = sumCount;
                max.clear();
                max.add(sum);
            }
            else if(sumCount == maxCount) max.add(sum);
        }

        int[] res = new int[max.size()];
        for(int i = 0; i < max.size(); i++) res[i] = max.get(i);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
