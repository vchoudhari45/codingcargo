package com.vc.easy;

/*****
 *  Problem No: 292
 *  Category: Data Structures And Algorithms
 *  Tags: Brainteaser, Leetcode, Easy
 *  Title: Nim Game
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones. Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap. It is a Brainteaser problem.
 *  Description: You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones. Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *  Input: 4
 *  Output: false
 *  Similar Question: Flip Game II
 *****/

class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 == 0;
    }
}
