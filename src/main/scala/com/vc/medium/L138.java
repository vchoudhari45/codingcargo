package com.vc.medium;

class Node138 {
    public int val;
    public Node138 next;
    public Node138 random;

    public Node138() {}

    public Node138(int _val) {
        val = _val;
    }

    public Node138(int _val,Node138 _next,Node138 _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class L138 {
    public Node138 copyRandomList(Node138 head) {
        java.util.Map<Node138, Node138> map = new java.util.HashMap<Node138, Node138>();
        Node138 current = head;
        while(current != null) {
            map.put(current, new Node138(current.val));
            current = current.next;
        }

        current = head;
        while(current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
