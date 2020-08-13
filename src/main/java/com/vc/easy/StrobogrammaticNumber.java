package com.vc.easy;

import java.util.HashMap;

/*****
 *  Problem No: 246
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Facebook, Leetcode, Easy
 *  Title: Strobogrammatic Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, A Strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). Write a function to determine if a number is strobogrammatic. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: A Strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). Write a function to determine if a number is strobogrammatic.
 *  Input: num = "1"
 *  Output: true
 *  Input: num = "69"
 *  Output: true
 *  Input: num = "88"
 *  Output: true
 *  Input: num = "962"
 *  Output: false
 *  Similar Question: Strobogrammatic Number II, Strobogrammatic Number III, Confusing Number
 *****/

class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(map.containsKey(ch)) str.insert(0, map.get(ch));
        }
        return str.toString().equals(num);
    }
}
