package com.vc.medium;

import java.util.*;

class L870 {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a: A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int i = 0; i < B.length; i++) {
            Integer nge = map.higherKey(B[i]);
            if(nge != null) {
                A[i] = nge;
            }
            else {
                nge = map.firstKey();
                A[i] = nge;
            }
            map.put(nge, map.getOrDefault(nge, 0) - 1);
            if(map.get(nge) == 0) map.remove(nge);
        }
        return A;
    }
}