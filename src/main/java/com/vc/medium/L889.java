package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.HashMap;

class L889 {
    private int[] pre, post;
    private HashMap<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        this.map = new HashMap<Integer, Integer>();
        for(int i = 0; i < pre.length; i++) map.put(pre[i], i);
        return helper(0, pre.length - 1, 0, pre.length - 1);
    }

    private TreeNode helper(int prestart, int preend, int poststart, int postend) {
        if(poststart == postend) return new TreeNode(post[poststart]);

        if(prestart > preend) return null;

        int rootValue = post[postend];
        TreeNode root = new TreeNode(rootValue);

        int divider = post[postend - 1];
        int dividerIndex = map.get(divider);

        int leftCount = dividerIndex - prestart - 1;
        int rightCount = preend - dividerIndex + 1;

        root.left = helper(prestart + 1, prestart + leftCount, poststart, poststart + leftCount - 1);
        root.right = helper(prestart + leftCount + 1, preend, postend - rightCount, postend - 1);

        return root;
    }
}

