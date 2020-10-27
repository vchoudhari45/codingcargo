package com.vc.hard;

import java.util.*;

class InsertDeleteGetRandomDuplicatesAllowed {

    private HashMap<Integer, Set<Integer>> indexMap;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !indexMap.containsKey(val);

        Set<Integer> set = indexMap.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        indexMap.put(val, set);
        list.add(val);

        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(indexMap.containsKey(val)) {
            int removeIndex = indexMap.get(val).iterator().next();
            int swapElement = list.get(list.size() - 1);

            indexMap.get(val).remove(removeIndex);
            indexMap.get(swapElement).add(removeIndex);
            indexMap.get(swapElement).remove(list.size() - 1);

            if(indexMap.get(val).size() == 0) indexMap.remove(val);

            list.set(removeIndex, swapElement);
            list.remove(list.size() - 1);

            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}