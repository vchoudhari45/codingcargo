package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 13
 *  Category: Data Structures And Algorithms
 *  Tags: Math, String, Leetcode, Easy
 *  Title: Roman to Integer
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, which converts Roman literal to an integer number, It is an easy problem that uses the HashTable lookup and Roman Literal conversation technique.
 *  Description: Convert given Roman literal to an integer number.
 *  Input: III
 *  Output: 3
 *  Input: IV
 *  Output: 4
 *  Input: IX
 *  Output: 9
 *  Input: LVIII
 *  Output: 58
 *  Input: MCMXCIV
 *  Output: 1994
 *  Similar Question: Integer to Roman
 *****/

class RomanToInteger {
    /**
     *  To convert Roman Literal to Integer value we have to make use of the lookup values as below
     *      Symbol       Value
     *        I             1
     *        V             5
     *        X             10
     *        L             50
     *        C             100
     *        D             500
     *        M             1000
     *
     *  Algorithm:
     *  1. Read ith character as "FIRST" character and lookup corresponding integer value
     *  2. Read (i + 1)th character as "SECOND" character, if (i + 1) < given roman string length and lookup corresponding integer value
     *  3. If SECOND > FIRST then add SECOND - FIRST to answer
     *     ELSE add FIRST to answer
     *  4. Continue running Step 1 to 3 on whole given string
     **/
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        int i = 0;
        int res = 0;
        while(i < s.length()) {
            int first = lookup.get(s.charAt(i));
            int second = 0;
            if(i + 1 < s.length()) {
                second = lookup.get(s.charAt(i + 1));
            }

            if(second > first) {
                res += (second - first);
                i += 2;
            }
            else {
                res += first;
                i++;
            }
        }
        return res;
    }
}