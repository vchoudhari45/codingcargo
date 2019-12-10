package com.vc.hard;

import java.util.*;

class LFUCache {

    Map<Integer, Integer> vals = new HashMap<Integer, Integer>();
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    Map<Integer, LinkedHashSet<Integer>> countGroups = new HashMap<Integer, LinkedHashSet<Integer>>();

    int capacity = 0;
    int min = 1;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        countGroups.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if(vals.containsKey(key)) {
            int oldCountGroup = counts.get(key);
            int newCountGroup = oldCountGroup + 1;

            //Update key's countGroup
            counts.put(key, newCountGroup);

            //Add key to newCountGroup
            LinkedHashSet<Integer> newCountGroupSet =
                    countGroups.getOrDefault(newCountGroup, new LinkedHashSet<Integer>());

            newCountGroupSet.add(key);
            countGroups.put(newCountGroup, newCountGroupSet);

            //Remove key from oldCountGroup
            countGroups.get(oldCountGroup).remove(key);
            if(oldCountGroup == min && countGroups.get(oldCountGroup).size() == 0) {
                min = newCountGroup;
            }

            return vals.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if(vals.containsKey(key)) {
            //Update key's countGroup
            get(key);
        }
        else {
            //Add key to countGroup 1
            if(vals.size() < capacity) {
                vals.put(key, value);
                counts.put(key, 1);
                countGroups.get(1).add(key);
                min = 1;
            }
            else {
                LinkedHashSet<Integer> set = countGroups.get(min);

                int firstElementToBeEvicted = set.iterator().next();
                vals.remove(firstElementToBeEvicted);
                counts.remove(firstElementToBeEvicted);
                set.remove(firstElementToBeEvicted);

                vals.put(key, value);
                counts.put(key, 1);
                countGroups.get(1).add(key);
                min = 1;
            }
        }
        vals.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */