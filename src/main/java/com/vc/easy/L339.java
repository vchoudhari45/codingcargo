package com.vc.easy;

import com.vc.hard.NestedInteger;

import java.util.List;

class L339 {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger list: nestedList) {
            helper(list, 1);
        }
        return sum;
    }

    private void helper(NestedInteger list, int depth) {
        if(list.isInteger()) sum += list.getInteger() * depth;
        else {
            for(NestedInteger l: list.getList()) {
                helper(l, depth + 1);
            }
        }
    }
}