package com.vc.easy;

// Definition for a QuadTree node.
class Node558 {
    public boolean val;
    public boolean isLeaf;
    public Node558 topLeft;
    public Node558 topRight;
    public Node558 bottomLeft;
    public Node558 bottomRight;

    public Node558() {}

    public Node558(boolean _val,boolean _isLeaf,Node558 _topLeft,Node558 _topRight,Node558 _bottomLeft,Node558 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class L558 {
    public Node558 intersect(Node558 t1, Node558 t2) {
        if(t1.isLeaf) {
            if(t1.val) return t1;
            else return t2;
        }
        if(t2.isLeaf) {
            if(t2.val) return t2;
            else return t1;
        }

        Node558 root = new Node558();
        root.topLeft = intersect(t1.topLeft, t2.topLeft);
        root.topRight = intersect(t1.topRight, t2.topRight);
        root.bottomRight = intersect(t1.bottomRight, t2.bottomRight);
        root.bottomLeft = intersect(t1.bottomLeft, t2.bottomLeft);

        if(root.topLeft.isLeaf
                && root.topRight.isLeaf
                && root.bottomRight.isLeaf
                && root.bottomLeft.isLeaf
                && root.topLeft.val == root.topRight.val
                && root.topRight.val == root.bottomLeft.val
                && root.bottomLeft.val == root.bottomRight.val
        ) {
            root.val = root.topLeft.val;
            root.isLeaf = true;
            root.topLeft = null;
            root.topRight = null;
            root.bottomRight = null;
            root.bottomLeft = null;
        }
        return root;
    }
}
