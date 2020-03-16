package com.vc.medium;

import java.util.*;

class L15 {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        if(n < 2) return res;

        for(int first = 0; first < n; first++) {
            if(first > 0 && arr[first] == arr[first - 1]) continue;

            int second = first + 1;
            int third = n - 1;

            while(second < third) {
                int total = arr[first] + arr[second] + arr[third];

                if(total > 0) {
                    third--;
                }
                else if(total < 0) {
                    second++;
                }
                else {
                    res.add(Arrays.asList(arr[first], arr[second], arr[third]));
                    while(second < third && arr[second] == arr[second + 1]) second++;
                    while(second < third && arr[third] == arr[third - 1]) third--;
                    second++;
                    third--;
                }
            }
        }
        return res;
    }
}
