package com.vc.medium;

class L255 {
    int index = 0;
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(int[] preorder, int min, int max) {
        if(preorder.length == index) return true;

        int root = preorder[index];
        if(root < min || root > max) return false;

        index++; //go to next element and try that element on left side and right side
        return helper(preorder, min, root) || helper(preorder, root, max);
    }
}
