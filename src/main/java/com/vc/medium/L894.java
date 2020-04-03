package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L894 {
    private HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(map.containsKey(N)) return map.get(N);

        List<TreeNode> res = new ArrayList<>();

        if(N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        if(N % 2 == 0) return res;

        for(int i = 0; i < N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        map.put(N, res);
        return res;
    }
}
