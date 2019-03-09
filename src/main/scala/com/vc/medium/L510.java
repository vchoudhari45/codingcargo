package com.vc.medium;

// Definition for a Node.
class Node510 {
    public int val;
    public Node510 left;
    public Node510 right;
    public Node510 parent;
}

class L510 {
    public Node510 inorderSuccessor(Node510 x) {
        Node510 result = x;
        if(x.right == null) {
            result = x.parent;
            while(result != null && result.val < x.val) {
                result = result.parent;
            }
            return result;
        }
        else {
            x = x.right;
            while(x != null) {
                result = x;
                x = x.left;
            }
        }
        return result;
    }
}
