package com.vc.hard;

import java.util.*;

class AllOne {

    class Bucket {
        int countValue;
        Bucket prev;
        Bucket next;
        HashSet<String> set;

        Bucket(int countValue) {
            this.countValue = countValue;
            this.set = new HashSet<>();
        }

        @Override
        public String toString() {
            return countValue+" "+set;
        }

    }

    Bucket head;
    Bucket tail;
    HashMap<String, Bucket> map;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //System.out.println("Incrementing "+key+" ============================");
        if(!map.containsKey(key)) {
            Bucket countOneBucket = null;
            if(head.next.countValue == 1) {
                countOneBucket = head.next;
            }
            else {
                countOneBucket = new Bucket(1);
                Bucket next = head.next;
                head.next = countOneBucket;
                countOneBucket.prev = head;
                countOneBucket.next = next;
                next.prev = countOneBucket;
            }
            countOneBucket.set.add(key);
            map.put(key, countOneBucket);
        }
        else {
            Bucket keyBucket = map.get(key);
            keyBucket.set.remove(key);

            if(keyBucket.next == tail || keyBucket.countValue + 1 != keyBucket.next.countValue) {
                Bucket newBucket = new Bucket(keyBucket.countValue + 1);
                Bucket prev = keyBucket.next.prev;
                keyBucket.next.prev = newBucket;
                newBucket.next = keyBucket.next;
                prev.next = newBucket;
                newBucket.prev = prev;
            }

            if(keyBucket.set.size() == 0) {
                Bucket prev = keyBucket.prev;
                Bucket next = keyBucket.next;
                prev.next = next;
                next.prev = prev;
            }

            keyBucket.next.set.add(key);
            map.put(key, keyBucket.next);
        }
        //debug();
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        //System.out.println("Decrementing "+key+" ============================");
        if(!map.containsKey(key)) return;
        else {
            Bucket toBeDeletedFrom = map.get(key);
            toBeDeletedFrom.set.remove(key);

            if(toBeDeletedFrom.countValue != 1) {
                if(toBeDeletedFrom.prev == head
                        || toBeDeletedFrom.prev.countValue + 1 != toBeDeletedFrom.countValue) {
                    Bucket inBetween = new Bucket(toBeDeletedFrom.countValue - 1);
                    Bucket next = toBeDeletedFrom.prev.next;
                    toBeDeletedFrom.prev.next = inBetween;
                    inBetween.prev = toBeDeletedFrom.prev;
                    inBetween.next = next;
                    next.prev = inBetween;
                    inBetween.set.add(key);
                }
                else toBeDeletedFrom.prev.set.add(key);

                map.put(key, toBeDeletedFrom.prev);
            }
            else map.remove(key);

            if(toBeDeletedFrom.set.size() == 0) {
                Bucket prev = toBeDeletedFrom.prev;
                Bucket next = toBeDeletedFrom.next;
                prev.next = next;
                next.prev = prev;
            }
        }
        //debug();
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        //System.out.println("Getting Max ============================");
        //debug();
        return tail.prev == head ? "" : tail.prev.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        //System.out.println("Getting Min ============================");
        //debug();
        return head.next == tail ? "" : head.next.set.iterator().next();
    }

    private void debug() {
        System.out.println("Debugging "+map);
        Bucket current = head.next;
        while(current != tail) {
            System.out.println(current);
            current = current.next;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
