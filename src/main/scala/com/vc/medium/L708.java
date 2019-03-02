package com.vc.medium;

class Node708 {
    public int val;
    public Node708 next;

    public Node708() {}

    public Node708(int _val,Node708 _next) {
        val = _val;
        next = _next;
    }
};

class L708 {
    public Node708 insert(Node708 head, int insertVal) {
        if(head == null) {
            Node708 node = new Node708();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        boolean find = false;
        Node708 prev = head;
        Node708 current = prev.next;
        while(current != head) {
            if(
                    prev.val <= insertVal && current.val >= insertVal ||
                    current.val < prev.val && insertVal >= prev.val ||
                    current.val < prev.val && insertVal <= current.val
            ){
                find = true;
                prev.next = new Node708(insertVal, current);
                break;
            }
            prev = current;
            current = current.next;
        }
        if(!find) {
            prev.next = new Node708(insertVal, current);
        }
        return head;
    }
}
