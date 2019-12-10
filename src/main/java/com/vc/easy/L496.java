package com.vc.easy;

import java.util.*;

class L496 {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr2.length; i++) {
            while(!st.isEmpty() && st.peek() < arr2[i]) map.put(st.pop(), arr2[i]);
            st.push(arr2[i]);
        }

        //System.out.println(map);

        int res[] = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            res[i] = map.getOrDefault(arr1[i], -1);
        }
        return res;
    }
}
