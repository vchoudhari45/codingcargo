package com.vc.medium;

import java.util.*;

class L658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while(hi - lo >= k) {
            if(Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) lo++;
            else hi--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = lo; i <= hi; i++) list.add(arr[i]);
        return list;
    }
}
