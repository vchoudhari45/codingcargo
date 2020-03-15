package com.vc.easy;

import java.util.*;

class L1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> res = new ArrayList<>();
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
            int first = arr1[i], second = arr2[j], third = arr3[k];
            if(first == second && second == third) {
                res.add(first);
                i++;
                j++;
                k++;
            }
            else if(first < second) {
                i++;
            }
            else if(second < third) {
                j++;
            }
            else k++;
        }
        return res;
    }
}
