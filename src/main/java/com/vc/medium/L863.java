package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L863 {

    private HashMap<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.parent = new HashMap<>();
        helper(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        while(K > 0) {
            int size = q.size();
            while(size > 0) {
                TreeNode e = q.poll();

                if(visited.contains(e)) {
                    size--;
                    continue;
                }

                visited.add(e);

                if(e.left != null && !visited.contains(e.left)) q.offer(e.left);
                if(e.right != null && !visited.contains(e.right)) q.offer(e.right);
                if(parent.containsKey(e) && !visited.contains(parent.get(e))) q.offer(parent.get(e));

                size--;
            }
            K--;
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) res.add(q.poll().val);
        return res;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        if(root.left != null) {
            //System.out.println(root.left.val+" parent: "+root.val);
            parent.put(root.left, root);
        }
        if(root.right != null) {
            //System.out.println(root.right.val+" parent: "+root.val);
            parent.put(root.right, root);
        }

        helper(root.left);
        helper(root.right);
    }
}
