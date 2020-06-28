package com.vc.easy;

/*****
 *  Problem No: 38
 *  Category: Data Structures And Algorithms
 *  Tags: String, Amazon, Microsoft, Leetcode, Easy
 *  Title: Count and Say
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. It is an easy problem that uses String Data Structure to solve the problem.
 *  Description: Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. count-and-say sequence is explained in solution.
 *  Input: 1
 *  Output: 1
 *  Input: 4
 *  Output: 1211
 *  Similar Question: Encode and Decode Strings, String Compression
 *****/

class CountAndSay {
    /**
     *  Problem Explanation
     *  Count-And-Say Sequence is generated as below
     *      1st Element    1        1st element starts with 1
     *
     *      2nd Element    11       2nd element is generated from 1st element as below
     *                              count how many same elements are there, Append it's count and number itself. Very Similar to Compression
     *                              in 1st element, we have only 1 element as 1, so 2nd element becomes 11
     *
     *      3rd Element    21       3rd element is generated from 2nd element in the same way
     *                              in 2nd element, we have 2 elements both of them are 1, so 3rd element becomes 21
     *
     *
     *      4th Element    1211     4th element is generated from 3rd element in the same way
     *                              in 3rd element we have 2 elements one 2 and one 1, so 4th element becomes 1211
     *
     *
     *      5th Element    111221   5th element is generated from 4th element in the same way
     *                              in 4th element we have 4 element one 1, one 2 and 2 ones, so 5th element becomes 111221
     *
     *      And so on.... Count element and Say, Given n, return nth such element.
     *
     *   Algorithm:
     *   Solution is based on String and Two Pointer as below
     **/
    public String countAndSay(int n) {
        String str = "1";
        while(n > 1) {
            str = solve(str);
            n--;
        }
        return str;
    }

    private String solve(String str) {
        StringBuilder res = new StringBuilder();
        int n = str.length();
        int i = 0, index = 0;
        while(i < n) {
            while(i < n && str.charAt(index) == str.charAt(i)) i++;
            res.append(i - index);
            res.append(str.charAt(index));
            index = i;
        }
        return res.toString();
    }
}
