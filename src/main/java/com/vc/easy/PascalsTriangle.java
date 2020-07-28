package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 118
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Amazon, Google, Leetcode, Easy
 *  Title: Pascal's Triangle
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. It is an easy problem that uses Arrays to solve the problem.
 *  Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *  Input: 5
 *  Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *  Similar Question: Pascal's Triangle II
 *****/

class PascalsTriangle {
    /**
     *  Think of pascal tree as below, it will make coming up with logic easier
     *  1st Row       1                     //Base Condition
     *  2nd Row       1  1
     *  3rd Row       1  2  1
     *  4th Row       1  3  3  1
     *  5th Row       1  4  6  4  1
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0) return res;

        res.add(Arrays.asList(1));

        for(int row = 1; row < numRows; row++) {
            List<Integer> prevList = res.get(row - 1);
            List<Integer> currentList = new ArrayList<>();

            currentList.add(1);
            for(int col = 0; col < row - 1; col++) {
                int currentValue = prevList.get(col);
                int nextValue = col + 1 < prevList.size() ? prevList.get(col + 1) : 0;
                currentList.add(currentValue + nextValue);
            }
            currentList.add(1);
            res.add(currentList);
        }
        return res;
    }
}