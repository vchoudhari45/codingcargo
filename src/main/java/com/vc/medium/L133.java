package com.vc.medium;

import java.util.*;

class L133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> nodes = new HashMap<>();

        Node clone = new Node(node.val, new ArrayList<Node>());
        nodes.put(node.val, clone);

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        HashSet<Integer> visited = new HashSet<>();
        while(!q.isEmpty()) {
            Node from = q.poll();
            if(visited.contains(from.val)) continue;

            visited.add(from.val);
            if(!nodes.containsKey(from.val)) nodes.put(from.val, new Node(from.val, new ArrayList<Node>()));
            Node fromClone = nodes.get(from.val);
            for(Node to: from.neighbors) {
                q.offer(to);
                if(!nodes.containsKey(to.val)) nodes.put(to.val, new Node(to.val, new ArrayList<Node>()));
                Node toClone = nodes.get(to.val);
                fromClone.neighbors.add(toClone);
            }
        }
        return clone;
    }
}
