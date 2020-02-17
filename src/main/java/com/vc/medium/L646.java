package com.vc.medium;

import java.util.*;

class L646 {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) return 0;

        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[1], y[1]);
            }
        });

        int out = 1;
        int end = pairs[0][1];
        for(int i = 1; i < pairs.length; i++) {
            //System.out.println(pairs[i][0]+" "+pairs[i][1]);
            if(end < pairs[i][0]) {
                //System.out.println("Picking...");
                out++;
                end = pairs[i][1];
            }
        }
        return out;
    }
}
