package com.vc.easy;

import java.util.ArrayList;
import java.util.List;


/*****
 *  Problem No: 119
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Leetcode, Easy
 *  Title: Pascal's Triangle II
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *  Input: 3
 *  Output: [1,3,3,1]
 *  Similar Question: Pascal's Triangle
 *****/

class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int row = 1; row <= rowIndex; row++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int col = 0; col < row - 1; col++) {
                int currentValue = res.get(col);
                int nextValue = col + 1 < res.size() ? res.get(col + 1) : 0;
                current.add(currentValue + nextValue);
            }
            current.add(1);
            res = current;
        }
        return res;
    }
}
