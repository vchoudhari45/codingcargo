package com.vc.hard;

import java.util.*;

class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }
        numbers.add(n);

        //We want kth element, so we skip (k - 1) elements as below
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            k -= index * factorial[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
        }
        return sb.toString();
    }
}