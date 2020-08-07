package com.vc.easy;


/*****
 *  Problem No: 171
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Excel Sheet Column Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a column title as appear in an Excel sheet, return its corresponding column number. It is an easy problem that uses Math to solve the problem.
 *  Description: Given a column title as appear in an Excel sheet, return its corresponding column number.
 *  Input: "A"
 *  Output: 1
 *  Input: "ZY"
 *  Output: 701
 *  Similar Question: Excel Sheet Column Title
 *****/

class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;

        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }
}
