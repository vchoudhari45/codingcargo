package com.vc.hard;

import java.util.*;

class LfuCache {

    private int capacity = 0;
    private int min = 1;
    private HashMap<Integer, Integer> valueMap;
    private HashMap<Integer, Integer> countMap;
    private HashMap<Integer, LinkedHashSet<Integer>> countGroupMap;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.valueMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.countGroupMap = new HashMap<>();
    }

    public int get(int key) {
        if(valueMap.containsKey(key)) {
            updateFrequency(key);
            return valueMap.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(valueMap.containsKey(key)) {
            updateFrequency(key);
            valueMap.put(key, value);
        }
        else {
            if(valueMap.size() == capacity) {
                LinkedHashSet<Integer> minCountSet = countGroupMap.getOrDefault(min, new LinkedHashSet<>());

                int toBeRemoved = minCountSet.iterator().next();

                //Remove from countGroupMap
                minCountSet.remove(toBeRemoved);

                //Remove from valueMap
                valueMap.remove(toBeRemoved);

                //Remove from countMap
                countMap.remove(toBeRemoved);

                put(key, value);
            }
            else {
                //Update valueMap
                valueMap.put(key, value);

                //Add to countMap
                countMap.put(key, 1);

                //Update countGroupMap
                LinkedHashSet<Integer> countSet = countGroupMap.getOrDefault(1, new LinkedHashSet<>());
                countSet.add(key);
                countGroupMap.put(1, countSet);

                //Update min
                min = 1;
            }
        }
    }

    private void updateFrequency(int key) {
        int oldCount = countMap.getOrDefault(key, 0);
        int newCount = oldCount + 1;

        //Update key's count
        countMap.put(key, newCount);

        //Remove key from oldCountGroup
        LinkedHashSet<Integer> oldSet = countGroupMap.getOrDefault(oldCount, new LinkedHashSet<>());
        oldSet.remove(key);
        if(oldSet.size() == 0) {
            countGroupMap.remove(oldCount);
            if(min == oldCount) min = newCount;
        }

        //Add key to newCountGroup
        LinkedHashSet<Integer> newSet = countGroupMap.getOrDefault(newCount, new LinkedHashSet<>());
        newSet.add(key);
        countGroupMap.put(newCount, newSet);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LfuCache obj = new LfuCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */