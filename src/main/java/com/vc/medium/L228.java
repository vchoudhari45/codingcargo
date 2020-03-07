package com.vc.medium;

import java.util.*;

class L228 {
    public List<String> summaryRanges(int[] arr) {
        if(arr == null || arr.length == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int start = 0, prev = arr[0], n = arr.length;
        for(int i = 1; i <= n; i++) {
            if(i == n || prev + 1 != arr[i]) {
                if(arr[start] == prev)
                    res.add(arr[start]+"");
                else
                    res.add(arr[start]+"->"+prev);
                start = i;
                if(i == n) return res;
            }
            prev = arr[i];
        }
        return res;
    }
}
