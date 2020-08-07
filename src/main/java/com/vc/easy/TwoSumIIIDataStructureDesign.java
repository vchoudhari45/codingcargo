package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 170
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Leetcode, Easy
 *  Title: Two Sum III Data structure design
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Design and implement a TwoSum class. It should support the following operations. Add - Add the number to an internal data structure. Find - Find if there exists any pair of numbers which sum is equal to the value. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: Design and implement a TwoSum class. It should support the following operations. Add - Add the number to an internal data structure. Find - Find if there exists any pair of numbers which sum is equal to the value.
 *  Input: add(1), add(3), add(5), find(4), find(7)
 *  Output: null, null, null, true, false
 *  Similar Question: Two Sum, Unique Word Abbreviation, Two Sum IV - Input is a BST
 *****/

class TwoSumIIIDataStructureDesign {

    private HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSumIIIDataStructureDesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int number) {
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int required = number - key;
            if((map.containsKey(required) && required != key) || (required == key && map.get(required) > 1)) return true;
        }
        return false;
    }
}

