package com.vc.easy;

import java.util.*;

class L1313 {
    public int[] decompressRLElist(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i += 2) {
            for(int j = 0; j < arr[i]; j++) list.add(arr[i + 1]);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
