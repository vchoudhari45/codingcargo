package com.vc.medium;

import java.util.*;

class L954 {
    public boolean canReorderDoubled(int[] A) {
        // count[x] = the number of occurrences of x in A
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) count.put(x, count.getOrDefault(x, 0) + 1);

        // B = A as Integer[], sorted by absolute value
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i) B[i] = A[i];

        Arrays.sort(B, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(Math.abs(i1), Math.abs(i2));
            }
        });

        //for(int i = 0; i < B.length; i++) System.out.println(B[i]);

        for (int x: B) {
            //System.out.println(x);

            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;

            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2*x, 0) <= 0) return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);

            count.put(2*x, count.get(2*x) - 1);
        }

        // If we have written everything, the answer is true
        return true;
    }
}