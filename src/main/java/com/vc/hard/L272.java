package com.vc.hard;


import java.util.*;

class L272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeMap<Double, List<Integer>> map = new TreeMap<>();
        solve(root, target, k, map);
        //System.out.println(map);
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Double, List<Integer>> entry: map.entrySet()) {
            for(Integer i: entry.getValue()) {
                if(count == k) break;
                res.add(i);
                count++;
            }
        }
        return res;
    }

    private void solve(TreeNode root, double target, int k, TreeMap<Double, List<Integer>> map) {
        if(root != null) {
            solve(root.left, target, k, map);
            int value = root.val;
            List<Integer> list = map.getOrDefault(Math.abs(target - value), new ArrayList<Integer>());
            list.add(value);
            map.put(Math.abs(target - value), list);
            solve(root.right, target, k, map);
        }
    }
}
