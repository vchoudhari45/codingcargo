package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L1305 {
    static class TreeIterator {
        Stack<TreeNode> st = new Stack<>();

        TreeIterator(TreeNode root) {
            TreeNode current = root;
            while(current != null) {
                st.push(current);
                current = current.left;
            }
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public int next() {
            TreeNode toReturn = st.pop();
            if(toReturn.right != null) {
                TreeNode current = toReturn.right;
                while(current != null) {
                    st.push(current);
                    current = current.left;
                }
            }
            return toReturn.val;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        TreeIterator t1 = new TreeIterator(root1);
        TreeIterator t2 = new TreeIterator(root2);

        //System.out.println(t1.st);
        //System.out.println(t2.st);

        List<Integer> list = new ArrayList<>();
        Integer ti1 = t1.hasNext() ? t1.next() : null;
        Integer ti2 = t2.hasNext() ? t2.next() : null;

        while(ti1 != null && ti2 != null) {
            if(ti1 > ti2) {
                list.add(ti2);
                ti2 = t2.hasNext() ? t2.next() : null;
            }
            else {
                list.add(ti1);
                ti1 = t1.hasNext() ? t1.next() : null;
            }
        }

        while(ti1 != null) {
            list.add(ti1);
            ti1 = t1.hasNext() ? t1.next() : null;
        }

        while(ti2 != null) {
            list.add(ti2);
            ti2 = t2.hasNext() ? t2.next() : null;
        }

        return list;
    }
}
