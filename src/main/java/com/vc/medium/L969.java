package com.vc.medium;

import java.util.*;

class L969 {
    public List<Integer> pancakeSort(int[] A) {
        //Reverse the current max number to the first place and then reverse it to the correct place.
        int currentMax = A.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            int index = findCurrentMax(A, currentMax);
            flip(A, index);
            flip(A, currentMax - 1);

            res.add(index + 1);
            res.add(currentMax--);
        }
        return res;
    }

    private int findCurrentMax(int[] A, int currentMax) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == currentMax) return i;
        }
        return -1;
    }

    private void flip(int[] A, int index) {
        int from = 0, to = index;
        while(from <= to) {
            int temp = A[from];
            A[from] = A[to];
            A[to] = temp;
            from++;
            to--;
        }
    }
}
