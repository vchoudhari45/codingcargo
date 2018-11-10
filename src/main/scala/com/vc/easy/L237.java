package com.vc.easy;

class ListNode237 {
    int val;
    ListNode237 next;
    ListNode237(int x) { val = x; }
}

class L237 {
    //head = [4,5,1,9], node = 5
    public static void deleteNode(ListNode237 node) {
        node.val = node.next.val;                           //Update the value of current node
        if(node.next.next != null) node = node.next;
        else node.next = null;                             //If it is last node then delete the node.next
    }
}