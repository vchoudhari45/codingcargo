package com.vc.easy;

import java.util.*;

/**
 *  // This is the custom function interface.
 *  // You should not implement it, or speculate about its implementation
 **/
class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return 0;
    }
};

class L1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= z; i++) {
            for(int j = 1; j <= z; j++) {
                if(customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
