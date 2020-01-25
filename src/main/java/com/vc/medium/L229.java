package com.vc.medium;

import java.util.*;

class L229 {
    public List<Integer> majorityElement(int[] arr) {
        /**
         In an array of length n, only 2 or less than two numbers can appear more than n / 3 times
         */
        int n = arr.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int major1 = 0;
        int major2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == major1) cnt1++;
            else if(arr[i] == major2) cnt2++;
            else if(cnt1 == 0) {
                cnt1++;
                major1 = arr[i];
            }
            else if(cnt2 == 0) {
                cnt2++;
                major2 = arr[i];
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == major1) cnt1++;
            else if(arr[i] == major2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        if(cnt1 > n / 3) res.add(major1);
        if(cnt2 > n / 3) res.add(major2);
        return res;
    }
}

