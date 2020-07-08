package com.vc.easy;

/*****
 *  Problem No: 58
 *  Category: Data Structures And Algorithms
 *  Tags: String, Easy
 *  Title: Length of Last Word
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a string str consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string. If the last word does not exist, return 0. It is an easy problem that uses String Data Structure to solve the problem.
 *  Description: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *  Input: "Hello World"
 *  Output: 5
 *****/
public class LengthOfLastWord {
    public int lengthOfLastWord(String str) {
        if(str == null) return 0;
        str = str.trim();
        int i = str.length() - 1;
        int length = 0;
        while(i >= 0) {
            if(str.charAt(i) == ' ') {
                return length;
            }
            length++;
            i--;
        }
        return length;
    }
}
