package com.vc.easy;

/*****
 *  Problem No: 243
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Amazon, Google, Leetcode, Easy
 *  Title: Shortest Word Distance
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *  Input: array = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 *  Output: 3
 *  Similar Question: Shortest Word Distance II, Shortest Word Distance III
 *****/

class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                word1Index = i;
                if(word2Index != -1) {
                    res = Math.min(res, word1Index - word2Index);
                }
            }
            else if(words[i].equals(word2)) {
                word2Index = i;
                if(word1Index != -1) {
                    res = Math.min(res, word2Index - word1Index);
                }
            }
        }
        return res;
    }
}
