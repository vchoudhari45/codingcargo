package com.vc.hard;


import java.util.HashMap;

class L1028 {
    HashMap<Integer, TreeNode> tree = new HashMap<>();
    public TreeNode recoverFromPreorder(String S) {
        int i = 0;
        while(i < S.length()) {
            int level = 0;
            while(i < S.length() && S.charAt(i) == '-') {
                level++;
                i++;
            }

            int number = 0;
            while(i < S.length() && S.charAt(i) != '-') {
                number = number * 10 + S.charAt(i) - '0';
                i++;
            }

            TreeNode node = new TreeNode(number);
            if(level != 0) {
                TreeNode parent = tree.get(level - 1);
                if(parent.left == null) parent.left = node;
                else parent.right = node;
            }
            tree.put(level, node);
        }
        return tree.get(0);
    }
}
