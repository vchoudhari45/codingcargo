package com.vc.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("NULL ");
        }
        else {
            sb.append(root.val);
            sb.append(" ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeList(q);
    }

    private TreeNode deserializeList(Queue<String> q) {
        if(q.isEmpty()) return null;

        String element = q.peek();

        if(element.equals("NULL")) {
            q.poll();
            return null;
        }
        else {
            int value = Integer.parseInt(element);
            q.poll();
            TreeNode root = new TreeNode(value);
            root.left = deserializeList(q);
            root.right = deserializeList(q);
            return root;
        }
    }
}