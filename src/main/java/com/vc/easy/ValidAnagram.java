package com.vc.easy;

import java.util.HashMap;

/*****
 *  Problem No: 242
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Valid Anagram
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given two strings s and t, write a function to determine if t is an anagram of s. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: Given two strings s and t, write a function to determine if t is an anagram of s.
 *  Input: s = "anagram", t = "nagaram"
 *  Output: true
 *  Similar Question: Group Anagrams, Palindrome Permutation, Find All Anagrams in a String
 *****/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))) return false;
            else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i)) == 0) map.remove(t.charAt(i));
            }
        }
        return map.size() == 0;
    }
}
