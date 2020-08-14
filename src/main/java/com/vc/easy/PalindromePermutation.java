package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 266
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Facebook, Leetcode, Easy
 *  Title: Palindrome Permutation
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a string, determine if a permutation of the string could form a palindrome. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: Given a string, determine if a permutation of the string could form a palindrome.
 *  Input: "code"
 *  Output: false
 *  Input: "aab"
 *  Output: true
 *  Input: "carerac"
 *  Output: true
 *  Similar Question: Longest Palindromic Substring, Valid Anagram, Palindrome Permutation II, Longest Palindrome
 *****/

class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean oddFoundAlready = false;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                if(oddFoundAlready) return false;
                else oddFoundAlready = true;
            }
        }
        return true;
    }
}