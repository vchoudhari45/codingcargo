package com.vc.hard;

import java.util.*;

class L135 {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        Arrays.fill(left, 1);
        int i = 1;
        while(i < n) {
            if(ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
            i++;
        }

        int[] right = new int[n];
        Arrays.fill(right, 1);
        i = n - 1;
        while(i > 0) {
            if(ratings[i] < ratings[i - 1]) {
                right[i - 1] = right[i] + 1;
            }
            i--;
        }

        int[] total = new int[n];
        for(int j = 0; j < n; j++) {
            total[j] = Math.max(left[j], right[j]);
        }

        int res = 0;
        for(int j = 0; j < n; j++) {
            res += total[j];
        }
        return res;
    }
}
