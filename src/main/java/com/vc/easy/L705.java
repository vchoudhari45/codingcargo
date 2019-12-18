package com.vc.easy;

class MyHashSet {

    static class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode[] arr;
    private int initialSize = 0;

    /** Initialize your data structure here. */
    public MyHashSet() {
        initialSize = 1000;
        arr = new ListNode[initialSize];
    }

    private int getIndex(int key) {
        return Integer.valueOf(key).hashCode() % initialSize;
    }

    public void add(int key) {
        int index = getIndex(key);
        if(arr[index] == null) {
            arr[index] = new ListNode(key);
        }
        else {
            ListNode current = arr[index];
            ListNode prev = current;
            while(current != null) {
                if(current.val == key) return;
                prev = current;
                current = current.next;
            }
            ListNode l = new ListNode(key);
            prev.next = l;
            l.prev = prev;
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
                    arr[index] = next;
                    if(next != null) next.prev = null;
                }
                else {
                    prev.next = next;
                    if(next != null) next.prev = prev;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if(arr[index] != null) {
            ListNode current = arr[index];
            while(current != null) {
                if(current.val == key) return true;
                current = current.next;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */