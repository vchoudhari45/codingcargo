package com.vc.medium;

class L708 {
    class Node {
        public int val;
        public Node next;
        public Node(int x) { val = x; }
    }

    public Node insert(Node head, int insertVal) {
        Node toInsert = new Node(insertVal);

        if(head == null) {
            head = toInsert;
            head.next = head;
            return head;
        }

        //Find min & max
        Node prev = head, max = head;
        Node current = prev.next;
        while(current != head) {
            if(max.val <= current.val) {
                max = current;
            }
            current = current.next;
        }
        Node min = max.next;
        //System.out.println(min.val+" "+max.val);

        //if value to be insert is greater than max or less than min then insert that after max
        if(insertVal <= min.val || insertVal >= max.val) {
            max.next = toInsert;
            toInsert.next = min;
            return head;
        }

        //System.out.println(prev.val+" "+current.val);
        prev = min;
        current = min.next;
        while(current != min) {
            if(prev.val <= insertVal && insertVal <= current.val) {
                prev.next = toInsert;
                toInsert.next = current;
                return head;
            }
            prev = current;
            current = current.next;
        }

        return toInsert;
    }
}