package com.vc.hard;

import java.util.*;

class AllOOneDataStructure {
    static class Bucket {
        Bucket prev;
        Bucket next;
        int count;
        HashSet<String> keys;

        Bucket(int count) {
            this.count = count;
            keys = new HashSet<>();
        }

        @Override
        public String toString() {
            return "[ "+count+ " "+ keys+" ]";
        }
    }

    private HashMap<String, Bucket> keyMap;
    private Bucket head, tail;

    /** Initialize your data structure here. */
    public AllOOneDataStructure() {
        keyMap = new HashMap<>();
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!keyMap.containsKey(key)) {
            if(head.next.count == 1) {
                head.next.keys.add(key);
                keyMap.put(key, head.next);
            }
            else {
                Bucket addedBucket = addBucketAfter(head, 1);
                addedBucket.keys.add(key);
                keyMap.put(key, addedBucket);
            }
        }
        else {
            Bucket oldBucket = keyMap.get(key);
            oldBucket.keys.remove(key);
            if(oldBucket.count + 1 == oldBucket.next.count) {
                oldBucket.next.keys.add(key);
                keyMap.put(key, oldBucket.next);
            }
            else {
                Bucket addedBucket = addBucketAfter(oldBucket, oldBucket.count + 1);
                addedBucket.keys.add(key);
                keyMap.put(key, addedBucket);
            }
            if(oldBucket.keys.size() == 0) removeBucket(oldBucket);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyMap.containsKey(key)) {
            Bucket oldBucket = keyMap.get(key);
            oldBucket.keys.remove(key);

            if(oldBucket.count - 1 == 0) {
                keyMap.remove(key);
                if(oldBucket.keys.size() == 0) removeBucket(oldBucket);
            }
            else {
                if(oldBucket.count - 1 == oldBucket.prev.count) {
                    oldBucket.prev.keys.add(key);
                    keyMap.put(key, oldBucket.prev);
                }
                else {
                    Bucket addedBucket = addBucketAfter(oldBucket.prev, oldBucket.count - 1);
                    addedBucket.keys.add(key);
                    keyMap.put(key, addedBucket);
                }
                if(oldBucket.keys.size() == 0) removeBucket(oldBucket);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(tail.prev != head && tail.prev.keys != null && tail.prev.keys.size() > 0)
            return tail.prev.keys.iterator().next();
        else return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next != tail && head.next.keys != null && head.next.keys.size() > 0)
            return head.next.keys.iterator().next();
        else return "";
    }

    private Bucket addBucketAfter(Bucket bucket, int val) {
        Bucket add = new Bucket(val);

        Bucket next = bucket.next;
        bucket.next = add;
        add.next = next;
        add.prev = bucket;

        next.prev = add;

        return add;
    }

    private void removeBucket(Bucket bucket) {
        Bucket prev = bucket.prev;
        Bucket next = bucket.next;

        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOOneDataStructure obj = new AllOOneDataStructure();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */