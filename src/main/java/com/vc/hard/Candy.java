package com.vc.hard;

import java.util.*;

class Candy {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;

        int n = ratings.length;

        int[] left = new int[n];
        Arrays.fill(left, 1);
        for(int i = 1; i < n; i++) {
            int leftElement = ratings[i - 1];
            int currentElement = ratings[i];
            if(leftElement < currentElement) left[i] = left[i - 1] + 1;
        }

        int[] right = new int[n];
        Arrays.fill(right, 1);
        for(int i = n - 2; i >= 0; i--) {
            int rightElement = ratings[i + 1];
            int currentElement = ratings[i];
            if(rightElement < currentElement) right[i] = right[i + 1] +  1;
        }

        int res = 0;
        for(int i = 0; i < n; i++) res += Math.max(left[i], right[i]);

        return res;
    }
}