package com.vc.medium;

import java.util.Arrays;
import java.util.Comparator;

class L179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2) {
                String first = s1 + s2;
                String second = s2 + s1;
                return second.compareTo(first);
            }
        });
        if(arr[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) sb.append(arr[i]);
        return sb.toString();
    }
}
