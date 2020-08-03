package com.vc.easy;


/*****
 *  Problem No: 125
 *  Category: Data Structures And Algorithms
 *  Tags: String, Two Pointer, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Valid Palindrome
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. Consider empty string as valid palindrome. It is an easy problem that uses Two Pointer Technique to solve the problem.
 *  Description: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. Consider empty string as valid palindrome.
 *  Input: "A man, a plan, a canal: Panama"
 *  Output: true
 *  Input: "race a car"
 *  Output: false
 *  Similar Question: Palindrome Linked List, Valid Palindrome II
 *****/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

            i++;
            j--;
        }
        return true;
    }
}
