package com.vc.medium;

import java.util.*;

class L259 {
    public int threeSumSmaller(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right) {
                if(arr[i] + arr[left] + arr[right] < target) {
                    count += right - left;
                    left++;
                }
                else right--;
            }
        }
        return count;
    }
}