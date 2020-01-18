package com.vc.easy;

import java.util.*;

class L1051 {
    public int heightChecker(int[] heights) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        for(Integer height: heights) {
            elements.put(height, elements.getOrDefault(height, 0) + 1);
        }

        int res = 0;
        int currentHeight = 0;
        for(int i = 0; i < heights.length; i++) {
            while(elements.getOrDefault(currentHeight, 0) == 0) currentHeight++;

            if(currentHeight != heights[i]) res++;

            elements.put(currentHeight, elements.getOrDefault(currentHeight, 0) - 1);
        }
        return res;
    }
}
