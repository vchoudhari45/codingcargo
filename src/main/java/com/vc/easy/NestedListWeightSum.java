package com.vc.easy;

import com.vc.hard.NestedInteger;

import java.util.List;

/*****
 *  Problem No: 339
 *  Category: Data Structures And Algorithms
 *  Tags: Depth First Search, Facebook, Leetcode, Easy
 *  Title: Nested List Weight Sum
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists. It is an easy problem that uses Depth First Search to solve the problem.
 *  Description: Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *  Input: [[1,1],2,[1,1]]
 *  Output: 10
 *  Input: [1,[4,[6]]]
 *  Output: 27
 *  Similar Question: Nested List Weight Sum II, Array Nesting, Employee Importance
 *****/

class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for(NestedInteger nestedInteger: nestedList) {
            if(nestedInteger.isInteger()) res += depth * nestedInteger.getInteger();
            else res += depthSum(nestedInteger.getList(), depth + 1);
        }
        return res;
    }
}