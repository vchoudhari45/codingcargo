package com.vc.medium;

import java.util.*;

class L60 {
    public String getPermutation(int n, int k) {
        int fact = 1;

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }
        //System.out.println(fact);

        k--;
        StringBuilder str = new StringBuilder();
        for(int i = n; i > 0; i--) {
            fact = fact / i;
            int index = (k / fact);
            k -= index * fact;
            str.append(numbers.remove(index));
        }
        return str.toString();
    }
}
