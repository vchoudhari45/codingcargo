package com.vc.easy;

import java.util.HashMap;

/*****
 *  Problem No: 205
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Isomorphic Strings
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
 *  Input: s = "egg", t = "add"
 *  Output: true
 *  Input: s = "foo", t = "bar"
 *  Output: false
 *  Input: s = "paper", t = "title"
 *  Output: true
 *  Similar Question: Word Pattern
 *****/

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char fromCh = s.charAt(i);
            char toCh = t.charAt(i);

            if(map.containsKey(fromCh) && map.get(fromCh) != toCh) return false;
            map.put(fromCh, toCh);

            if(reverseMap.containsKey(toCh) && reverseMap.get(toCh) != fromCh) return false;
            reverseMap.put(toCh, fromCh);
        }
        return true;
    }
}
