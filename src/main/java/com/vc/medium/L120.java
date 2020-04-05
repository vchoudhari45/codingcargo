package com.vc.medium;

import java.util.*;

class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
             input
             [2]
             [3,4]
             [6,5,7]
             [4,1,8,3]

             output
             [11]
             [9,10]
             [7,6,10]
             [4,1,8,3]
         */

        if(triangle == null || triangle.size() == 0) return 0;

        int n = triangle.size();
        for(int i = n - 2; i >= 0; i--) {
            int rowAbove = i;
            int rowBelow = i + 1;

            for(int j = 0; j < triangle.get(rowAbove).size(); j++) {
                int min = Math.min(triangle.get(rowBelow).get(j), triangle.get(rowBelow).get(j + 1));
                int value = triangle.get(rowAbove).get(j);
                triangle.get(rowAbove).set(j, value + min);
            }
        }
        return triangle.get(0).get(0);
    }
}