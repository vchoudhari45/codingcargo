package com.vc.medium;

import java.util.*;

class RandomizedSet {


    HashMap<Integer, Integer> map = new HashMap();
    List<Integer> list = new ArrayList<Integer>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if(res) {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if(res) {
            int indexToBeRemoved = map.get(val);
            int lastIndexItem = list.get(list.size() - 1);

            map.put(lastIndexItem, indexToBeRemoved);
            map.remove(val);

            list.set(indexToBeRemoved, lastIndexItem);
            list.remove(list.size() - 1);
        }
        return res;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */