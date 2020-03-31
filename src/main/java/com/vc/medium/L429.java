package com.vc.medium;

import com.vc.hard.Node;

import java.util.*;

class L429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> inner = new ArrayList<>();
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node != null) {
                inner.add(node.val);
                if(node.children == null) continue;
                for(Node child: node.children) q.offer(child);
            }
            else {
                res.add(new ArrayList<>(inner));
                inner.clear();
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return res;
    }
}
