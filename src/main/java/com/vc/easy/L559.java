package com.vc.easy;

import com.vc.hard.Node;

class L559 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        else {
            int max = 0;
            for(Node child: root.children) {
                max = Math.max(max, maxDepth(child));
            }
            return 1 + max;
        }
    }
}