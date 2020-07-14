package com.vc.easy;

/*****
 *  Problem No: 67
 *  Category: Data Structures And Algorithms
 *  Tags: Math, String, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: Add Binary
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given two binary strings, return their sum (also a binary string). It is an easy problem that uses String Data Structure & Math to solve the problem.
 *  Description: Given two binary strings, return their sum (also a binary string). The input strings are both non-empty and contains only characters 1 or 0.
 *  Input: a = "11", b = "1"
 *  Output: "100"
 *  Input: a = "1010", b = "1011"
 *  Output: "10101"
 *  Similar Question: Add Two Numbers, Multiply Strings, Plus One, Add to Array Form of Integer
 *****/

class AddBinary {
    public String addBinary(String a, String b) {
        int ia = a.length() - 1;
        int ib = b.length() - 1;

        //carry is initially zero
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(ia >= 0 && ib >= 0) {
            //Increment carry, if character is 1
            if(a.charAt(ia) == '1') carry++;
            if(b.charAt(ib) == '1') carry++;

            //If carry is divisible by 1 then insert 0 else 1
            if(carry % 2 == 1) sb.append("1");
            else sb.append("0");

            //Update carry
            carry = carry / 2;

            ia--;
            ib--;
        }

        while(ia >= 0) {
            if(a.charAt(ia) == '1') carry++;

            if(carry % 2 == 1) sb.append("1");
            else sb.append("0");

            carry = carry / 2;
            ia--;
        }

        while(ib >= 0) {
            if(b.charAt(ib) == '1') carry++;

            if(carry % 2 == 1) sb.append("1");
            else sb.append("0");

            carry = carry / 2;
            ib--;
        }

        if(carry == 1) sb.append("1");

        return sb.reverse().toString();
    }
}