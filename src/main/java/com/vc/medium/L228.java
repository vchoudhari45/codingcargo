package com.vc.medium;

import java.util.*;

class L228 {
    public List<String> summaryRanges(int[] arr) {
        List<String> list = new ArrayList<String>();

        int n = arr.length;
        if(n == 0) return list;

        int start = arr[0];
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(prev + 1 == arr[i]) {
                prev = arr[i];
            }
            else {
                if(start != arr[i - 1]) list.add(start+"->"+arr[i - 1]);
                else list.add(start+"");

                start = arr[i];
                prev = start;
            }
        }
        if(prev == start) list.add(prev+"");
        else list.add(start+"->"+prev);
        return list;
    }
}
