package com.vc.medium;

import com.vc.hard.NestedInteger;

import java.util.*;

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
