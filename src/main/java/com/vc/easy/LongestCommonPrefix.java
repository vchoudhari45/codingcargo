package com.vc.easy;

/*****
 *  Problem No: 14
 *  Category: Data Structures And Algorithms
 *  Tags: String, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Longest Common Prefix
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem which, find the longest common prefix string amongst an array of strings, It is an easy problem that uses string function to find the longest common prefix string amongst an array of strings.
 *  Description: Find the longest common prefix string amongst an array of strings.
 *  Input: ["flower","flow","flight"]
 *  Output: "fl"
 *  Input: ["dog","racecar","car"]
 *  Output: ""
 *****/

class LongestCommonPrefix {
    /**
     *  Gotchas
     *  1. Not all elements in an array will have same length
     *
     *  Algorithm
     *  1. If a given array is null or empty return empty string
     *  2. Else consider first element in an array as prefix
     *     2.1. Loop over every character in prefix
     *     2.2. Check if character at ith index in prefix matches with all other strings in a given array at same ith index
     *     2.3  Else continue to iterate over next index
     **/
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        int i = 0;
        while(i < prefix.length()) {
            for(String str: strs) {
                if(str.length() <= i || str.charAt(i) != prefix.charAt(i)) return prefix.substring(0, i);
            }
            i++;
        }
        return prefix;
    }
}
