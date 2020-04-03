package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L742 {
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode start = null;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == k) start = node;
            if(node.left != null) {
                addEdge(node.left, node, graph);
                q.offer(node.left);
            }
            if(node.right != null) {
                addEdge(node.right, node, graph);
                q.offer(node.right);
            }
        }

        //System.out.println("Value: "+start);
        q.clear();
        q.offer(start);
        HashSet<TreeNode> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode element = q.poll();

                if(element.left == null && element.right == null) return element.val;
                if(visited.contains(element) || !graph.containsKey(element)) continue;

                visited.add(element);
                for(TreeNode node: graph.get(element)) q.offer(node);
            }
        }
        return -1;
    }

    private void addEdge(TreeNode fromNode, TreeNode toNode,
                         HashMap<TreeNode, List<TreeNode>> graph) {
        List<TreeNode> fromList = graph.getOrDefault(fromNode, new ArrayList<>());
        List<TreeNode> toList = graph.getOrDefault(toNode, new ArrayList<>());

        fromList.add(toNode);
        graph.put(fromNode, fromList);

        toList.add(fromNode);
        graph.put(toNode, toList);
    }
}
