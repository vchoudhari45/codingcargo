package com.vc.hard;

import java.util.*;

class LFUCache {

    /**
         1.Key-Value Map
             key1 => value1
             key2 => value2
             key3 => value3

         2. Key-Count Map
             key1 => count1
             key2 => count2
             key3 => count2

         3. CountGroup Map
            count1 => List(key1)
            count2 => List(key2, key3)
     */
    int min = 1;
    int capacity = 0;
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> count;
    HashMap<Integer, LinkedHashSet<Integer>> countGroup;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        count = new HashMap<>();
        countGroup = new HashMap<>();
    }

    public int get(int key) {
        // System.out.println("============================================");
        // System.out.println("Before getting key: "+key);
        // System.out.println("Map: "+map);
        // System.out.println("Count: "+count);
        // System.out.println("CountGroup: "+countGroup);
        if(map.containsKey(key)) {
            int oldCount = count.get(key);
            int newCount = oldCount + 1;

            LinkedHashSet<Integer> oldSet = countGroup.get(oldCount);
            oldSet.remove(key);
            if(oldSet.size() == 0) {
                countGroup.remove(oldCount);
                if(oldCount == min) min++;
            }
            else countGroup.put(oldCount, oldSet);

            LinkedHashSet<Integer> newSet = countGroup.getOrDefault(newCount, new LinkedHashSet<Integer>());
            newSet.add(key);

            countGroup.put(newCount, newSet);
            count.put(key, newCount);
        }
        // System.out.println("After getting key: "+key);
        // System.out.println("Map: "+map);
        // System.out.println("Count: "+count);
        // System.out.println("CountGroup: "+countGroup);
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        // System.out.println("============================================");
        // System.out.println("Before adding key: "+key+" value: "+value);
        // System.out.println("Map: "+map);
        // System.out.println("Count: "+count);
        // System.out.println("CountGroup: "+countGroup);
        if(map.containsKey(key)) {
            get(key);
            map.put(key, value);
        }
        else {
            if(map.size() == capacity) {
                LinkedHashSet<Integer> set = countGroup.get(min);
                int toBeRemoved = set.iterator().next();
                set.remove(toBeRemoved);
                if(set.size() == 0) countGroup.remove(min);
                else countGroup.put(min, set);
                map.remove(toBeRemoved);
                count.remove(toBeRemoved);
            }
            map.put(key, value);
            count.put(key, 1);
            LinkedHashSet<Integer> set = countGroup.getOrDefault(1, new LinkedHashSet<Integer>());
            set.add(key);
            countGroup.put(1, set);
            min = 1;
        }
        // System.out.println("After adding key: "+key+" value: "+value);
        // System.out.println("Map: "+map);
        // System.out.println("Count: "+count);
        // System.out.println("CountGroup: "+countGroup);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */