package com.vc.hard;

import java.util.*;

class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // System.out.println("Before inserting :"+ val);
        // printStuff();
        boolean res = !map.containsKey(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
        set.add(list.size());
        list.add(val);
        map.put(val, set);
        // System.out.println("After inserting: "+val);
        // printStuff();
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // System.out.println("Before removing :"+ val);
        // printStuff();
        if(map.containsKey(val)) {
            int remove = map.get(val).iterator().next();
            int swap = list.get(list.size() - 1);

            map.get(val).remove(remove);
            map.get(swap).add(remove);
            map.get(swap).remove(list.size() - 1);
            if(map.get(val).size() == 0) map.remove(val);

            list.set(remove, swap);
            list.remove(list.size() - 1);
            // System.out.println("After removing :"+ val);
            // printStuff();
            return true;
        }
        // System.out.println("After removing :"+ val);
        // printStuff();
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    private void printStuff() {
        System.out.println(map);
        System.out.println(list);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */