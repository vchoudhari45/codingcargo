package com.vc.easy;

class MyHashMap {

    static class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int value;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListNode[] arr;
    private int initialSize;

    /** Initialize your data structure here. */
    public MyHashMap() {
        initialSize = 1000;
        arr = new ListNode[initialSize];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(arr[index] == null) {
            arr[index] = new ListNode(key, value);
        }
        else {
            ListNode current = arr[index];
            ListNode prev = current;
            while(current != null) {
                if(current.key == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            ListNode l = new ListNode(key, value);
            prev.next = l;
            l.prev = prev;
        }
    }

    private int getIndex(int key) {
        return Integer.valueOf(key).hashCode() % initialSize;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(arr[index] != null) {
            ListNode current = arr[index];
            while(current != null) {
                if(current.key == key) return current.value;
                current = current.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(arr[index] != null) {
            ListNode current = arr[index];
            while(current != null) {
                if(current.key == key) {
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
                current = current.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
