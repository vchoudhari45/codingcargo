package com.vc.medium;

import java.util.*;

class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node(int key, int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
        this.key = key;
    }

    Node(Node next, Node prev, int key, int value) {
        this.key = key;
        this.next = next;
        this.prev = prev;
        this.value = value;
    }
}

class LRUCache {

    Node head, tail;
    Map<Integer, Node> map;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        //System.out.println("Getting "+key);
        boolean res = map.containsKey(key);
        if(res) {
            Node recentlyFetched = map.get(key);

            Node recentlyFetchedPrev = recentlyFetched.prev;
            Node recentlyFetchedNext = recentlyFetched.next;

            recentlyFetchedPrev.next = recentlyFetchedNext;
            recentlyFetchedNext.prev = recentlyFetchedPrev;

            Node oldHeadNext = head.next;
            head.next = recentlyFetched;
            recentlyFetched.prev = head;

            recentlyFetched.next = oldHeadNext;
            oldHeadNext.prev = recentlyFetched;

            //System.out.println("After getting "+key);
            //printStuff();
            return map.get(key).value;
        }
        //System.out.println("After getting "+key);
        //printStuff();
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        boolean res = map.containsKey(key);
        if(res) {
            get(key);
            map.get(key).value = value;
        }
        else {
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next.prev = newNode;

            if(map.size() == capacity) {
                Node toBeEvicted = tail.prev;
                Node toBeEvictedPrev = toBeEvicted.prev;
                toBeEvictedPrev.next = tail;
                tail.prev = toBeEvictedPrev;
                map.remove(toBeEvicted.key);
            }
            map.put(key, newNode);
        }
        //System.out.println("After inserting "+key+" Value "+value);
        //printStuff();
    }

    public void printStuff() {
        Node current = head;
        System.out.print("[ ");
        while(current != null) {
            System.out.print(current.value+", ");
            current = current.next;
        }
        System.out.println(" ]");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
