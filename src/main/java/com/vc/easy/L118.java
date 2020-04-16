package com.vc.easy;

import java.util.*;

class L118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0) return res;
        res.add(Arrays.asList(1));

        for(int row = 1; row < numRows; row++) {
            List<Integer> prevList = res.get(row - 1);
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for(int col = 0; col < row - 1; col++) {
                int nextValue = col + 1 < prevList.size() ? prevList.get(col + 1) : 0;
                int currentValue = prevList.get(col);
                currentList.add(currentValue + nextValue);
            }
            currentList.add(1);
            res.add(currentList);
        }
        return res;
    }
}
