package com.vc.medium;

import java.util.*;

class L356 {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<String>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] point: points) {
            int x = point[0], y = point[1];
            String key = x +" "+y;
            set.add(key);
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int sum = min + max;
        for(int[] point: points) {
            int x = point[0], y = point[1];
            String key = (sum - x)+" "+y;
            if(!set.contains(key)) return false;
        }
        return true;
    }
}
