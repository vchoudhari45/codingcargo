package com.vc.medium;

import com.vc.hard.TreeNode;

class L450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode current = root;
        while(current != null && current.val != key) {
            parent = current;
            if(current.val < key) current = current.right;
            else current = current.left;
        }

        if(parent == null) {
            return deleteNode(current);
        }
        else if(parent.left == current) {
            parent.left = deleteNode(current);
        }
        else if(parent.right == current) {
            parent.right = deleteNode(current);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root) {
        //Case 1: node to be deleted not found
        if(root == null) return null;

        //Case 2: node to be deleted is leaf node
        if(root.left == null && root.right == null) return null;

        //Case 3: node to be deleted has right child
        else if(root.left == null) return root.right;

        //Case 4: node to be deleted has left child
        else if(root.right == null) return root.left;

        //Case 5: node to be deleted has both left & right child
        else {
            //find leftmost node of node to be deleted's right child(InOrder Successor)
            TreeNode minNode = root.right;
            TreeNode parent = root;
            while(minNode.left != null) {
                parent = minNode;
                minNode = minNode.left;
            }
            //Assign it's value to root node
            root.val = minNode.val;

            //if InOrder Successor has right child, reassign it to it's parent
            if(parent.left == minNode) parent.left = minNode.right;
            else parent.right = minNode.right;
            return root;
        }
    }
}
