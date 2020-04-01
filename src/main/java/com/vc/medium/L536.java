package com.vc.medium;

import com.vc.hard.TreeNode;

class L536 {
    int index = 0;
    public TreeNode str2tree(String s) {
        char[] arr = s.toCharArray();
        return helper(arr);
    }

    private TreeNode helper(char[] arr) {
        if(arr.length == index) return null;

        StringBuilder number = new StringBuilder();
        while(index < arr.length && (Character.isDigit(arr[index]) || arr[index] == '-')) {
            number.append(arr[index]);
            index++;
        }

        if(number.length() == 0) return null;

        TreeNode root = new TreeNode(Integer.parseInt(number.toString()));
        if(index < arr.length && arr[index] == '(') {
            index++;
            root.left = helper(arr);
            index++;

            if(index < arr.length && arr[index] == '(') {
                index++;
                root.right = helper(arr);
                index++;
            }
        }
        return root;
    }
}
