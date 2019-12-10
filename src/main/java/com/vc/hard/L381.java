package com.vc.hard;

import java.util.*;

class RandomizedCollection {

    /** Initialize your data structure here. */
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    List<int[]> list = new ArrayList<int[]>();

    Random random = new Random();
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        List<Integer> indexList = map.getOrDefault(val, new ArrayList<Integer>());
        indexList.add(list.size());
        map.put(val, indexList);
        list.add(new int[] { val, indexList.size() - 1 });
        //System.out.print("After Inserting "+val);
        //printStuff();
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if(res) {
            int[] swapElement = list.get(list.size() - 1);
            int swapElementValue = swapElement[0];
            int swapElementIndexInList = swapElement[1];

            List<Integer> removeElementList = map.get(val);
            int removeElementIndexInMainList = removeElementList.get(removeElementList.size() - 1);

            List<Integer> swapElementList = map.get(swapElementValue);
            swapElementList.set(swapElementIndexInList, removeElementIndexInMainList);

            removeElementList.remove(removeElementList.size() - 1);
            if(removeElementList.size() == 0) map.remove(val);
            else map.put(val, removeElementList);

            list.set(removeElementIndexInMainList, swapElement);
            list.remove(list.size() - 1);
        }
        //System.out.print("After removing "+val);
        //printStuff();
        return res;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()))[0];
    }

    private void printStuff() {
        System.out.println(" ");
        System.out.println("Printing Map");
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
        System.out.print("[");
        for(int[] elements: list) {
            System.out.print(" ("+elements[0]+", "+elements[1]+"), ");
        }
        System.out.println("] ");
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
