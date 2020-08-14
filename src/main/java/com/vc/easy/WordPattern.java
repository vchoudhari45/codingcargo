package com.vc.easy;

import java.util.HashMap;

/*****
 *  Problem No: 290
 *  Category: Data Structures And Algorithms
 *  Tags: String, Amazon, Microsoft, Leetcode, Easy
 *  Title: Word Pattern
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. It is an easy problem that uses String Data Structure to solve the problem.
 *  Description: Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. count-and-say sequence is explained in solution.
 *  Input: 1
 *  Output: 1
 *  Input: 4
 *  Output: 1211
 *  Similar Question: Encode and Decode Strings, String Compression
 *****/

class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Object, Integer> map = new HashMap<>();

        String[] sArr = str.split(" ");
        if(sArr.length != pattern.length()) return false;
        for(int i = 0; i < sArr.length; i++) {
            if(!map.containsKey(pattern.charAt(i))) map.put(pattern.charAt(i), i);
            if(!map.containsKey(sArr[i])) map.put(sArr[i], i);

            int stringIndex = map.get(sArr[i]);
            int patternIndex = map.get(pattern.charAt(i));
            if(stringIndex != patternIndex) return false;
        }

        return true;
    }
}
