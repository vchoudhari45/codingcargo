package com.vc.easy;

import java.util.Stack;

/*****
 *  Problem No: 20
 *  Category: Data Structures And Algorithms
 *  Tags: String, Stack, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Valid Parentheses
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem which, determines if the input string contains valid Parentheses, It is an easy problem that uses stack Data Structure.
 *  Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  Input: "()"
 *  Output: true
 *  Input: "()[]{}"
 *  Output: true
 *  Input: "(]"
 *  Output: false
 *  Input: "([)]"
 *  Output: false
 *  Input: "{[]}"
 *  Output: true
 *  Similar Question: Generate Parentheses, Longest Valid Parentheses, Remove Invalid Parentheses, Check If Word Is Valid After Substitutions
 *****/

class ValidParentheses {
    /**
     *  Algorithm
     *  1. If Given String is null or empty return true
     *  2. Else iterate over all characters of a given String
     *     2.1. If character is closing bracket and if stack is empty or character at the top of the stack is NOT corresponding opening bracket then return false
     *     2.2. Else push the character to stack
     *  3. Continue until all the characters in a given String are iterated
     **/
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case ')': if(st.isEmpty() || st.pop() != '(') return false;
                    break;
                case '}': if(st.isEmpty() || st.pop() != '{') return false;
                    break;
                case ']': if(st.isEmpty() || st.pop() != '[') return false;
                    break;
                default: st.push(ch);
            }
        }
        return st.isEmpty();
    }
}