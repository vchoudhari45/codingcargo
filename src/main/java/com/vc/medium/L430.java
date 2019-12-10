package com.vc.medium;

class Node430 {
    public int val;
    public Node430 prev;
    public Node430 next;
    public Node430 child;

    public Node430() {}

    public Node430(int _val,Node430 _prev,Node430 _next,Node430 _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class L430 {
    public Node430 flatten(Node430 head) {
        Node430 current = head;
        while(current != null) {
            if(current.child != null) {
                Node430 next = current.next;
                Node430 child = current.child;
                current.child.prev = current;
                current.next = child;
                current.child = null;
                while(child.next != null) {
                    child = child.next;
                }
                child.next = next;
                if(next != null) next.prev = child;
            }
            current = current.next;
        }
        return head;
    }
}
