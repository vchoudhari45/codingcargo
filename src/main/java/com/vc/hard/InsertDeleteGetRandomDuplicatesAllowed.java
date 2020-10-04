package com.vc.hard;

import java.util.*;

class InsertDeleteGetRandomDuplicatesAllowed {

    private HashMap<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);

        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        map.put(val, set);
        list.add(val);

        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int removeIndex = map.get(val).iterator().next();
            int swapElement = list.get(list.size() - 1);

            map.get(val).remove(removeIndex);
            map.get(swapElement).add(removeIndex);
            map.get(swapElement).remove(list.size() - 1);

            if(map.get(val).size() == 0) map.remove(val);

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