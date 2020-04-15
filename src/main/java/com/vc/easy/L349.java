package com.vc.easy;

import java.util.*;

class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) set.add(nums1[i]);

        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] r = new int[res.size()];
        int index = 0;
        for(Integer element: res) r[index++] = element;
        return r;
    }
}