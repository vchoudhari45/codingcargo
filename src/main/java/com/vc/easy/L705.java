package com.vc.easy;

class MyHashSet {

    class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode[] arr;
    private int initialSize;

    /** Initialize your data structure here. */
    public MyHashSet() {
        initialSize = 1000;
        arr = new ListNode[initialSize];
    }

    public void add(int key) {
        int index = getIndex(key);
        if(arr[index] == null) {
            arr[index] = new ListNode(key);
        }
        else if(!contains(key)) {
            ListNode l = new ListNode(key);
            ListNode next = arr[index].next;
            arr[index].next = l;
            l.prev = arr[index];
            l.next = next;
            if(next != null) next.prev = l;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        if(arr[index] != null) {
            ListNode current = arr[index];
            while(current != null) {
                if(current.val == key) break;
                current = current.next;
            }
            if(current != null) {
                ListNode prev = current.prev;
                ListNode next = current.next;
                if(prev == null) {
                    arr[index] = current.next;
                }
                else {
                    prev.next = next;
                    if(next != null) next.prev = prev;
                }
            }
        }
    }

    private int getIndex(int key) {
        return Integer.valueOf(key).hashCode() % initialSize;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if(arr[index] == null) return false;
        else {
            ListNode current = arr[index];
            while(current != null) {
                if(current.val == key) return true;
                current = current.next;
            }
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
