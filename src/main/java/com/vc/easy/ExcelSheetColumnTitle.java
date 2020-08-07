package com.vc.easy;


/*****
 *  Problem No: 168
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Excel Sheet Column Title
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a positive integer, return its corresponding column title as appear in an Excel sheet. It is an easy problem that uses Math to solve the problem.
 *  Description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *  Input: 28
 *  Output: "AB"
 *  Input: 701
 *  Output: "ZY"
 *  Similar Question: Excel Sheet Column Number
 *****/

class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            sb.insert(0, ch);
        }
        return sb.toString();
    }
}