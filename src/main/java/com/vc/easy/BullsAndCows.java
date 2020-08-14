package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 299
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Amazon, Google, Microsoft, Leetcode, Easy
 *  Title: Bulls and Cows
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Bulls and Cows Game. It is an easy problem that uses Hash Table to solve the problem.
 *  Description: You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number. Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. Please note that both secret number and friend's guess may contain duplicate digits.
 *  Input: secret = "1807", guess = "7810"
 *  Output: "1A3B"
 *****/

class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
            char sch = secret.charAt(i);
            char gch = guess.charAt(i);
            //Add everything except bulls
            if(sch != gch) map.put(sch, map.getOrDefault(sch, 0) + 1);
        }

        for(int i = 0; i < guess.length(); i++) {
            char gch = guess.charAt(i);
            char sch = secret.charAt(i);
            if(gch == sch) bulls++;
            else if(map.getOrDefault(gch, 0) > 0) {
                cows++;
                map.put(gch, map.get(gch) - 1);
            }
        }

        return bulls+"A"+cows+"B";
    }
}
