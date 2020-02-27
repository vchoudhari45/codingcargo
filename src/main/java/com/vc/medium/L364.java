package com.vc.medium;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class L364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();

        for(NestedInteger nestedInteger: nestedList) {
            if(nestedInteger != null) queue.offer(nestedInteger);
        }

        int res = 0;
        int prevSum = 0;
        while(!queue.isEmpty()) {
            int levelSum = 0;
            int size = queue.size();
            while(size > 0) {
                NestedInteger nestedInteger = queue.poll();
                if(nestedInteger.isInteger()) {
                    levelSum += nestedInteger.getInteger();
                }
                else {
                    for(NestedInteger subNestedInteger: nestedInteger.getList()) {
                        if(subNestedInteger != null) queue.offer(subNestedInteger);
                    }
                }
                size--;
            }
            res += prevSum + levelSum;
            prevSum += levelSum;
        }
        return res;
    }
}
