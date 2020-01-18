package com.vc.medium;

import java.util.*;

class L163 {
    public List<String> findMissingRanges(int[] arr, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= arr.length; i++) {
            long start = i == 0 ? lower : (long)arr[i - 1] + 1;
            long end = i == arr.length ? upper : (long)arr[i] - 1;

            if(start == end) {
                res.add(String.valueOf(start));
            }
            else if(end - start >= 1) {
                res.add(String.valueOf(start)+"->"+String.valueOf(end));
            }
        }
        return res;
    }
}