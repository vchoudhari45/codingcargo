package com.vc.easy;

import java.util.ArrayList;
import java.util.List;

/*****
 *  Problem No: 293
 *  Category: Data Structures And Algorithms
 *  Tags: String, Google, Leetcode, Easy
 *  Title: Flip Game
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner. Write a function to compute all possible states of the string after one valid move. It is an easy problem that uses String operations to solve the problem.
 *  Description: You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner. Write a function to compute all possible states of the string after one valid move.
 *  Similar Question: Flip Game II
 *****/

class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        char[] sArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                sArr[i] = '-';
                sArr[i + 1] = '-';
                list.add(new String(sArr));
                sArr[i] = '+';
                sArr[i + 1] = '+';
            }
        }
        return list;
    }
}
