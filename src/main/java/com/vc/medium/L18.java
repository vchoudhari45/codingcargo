package com.vc.medium;

import java.util.*;

class L18 {

    public ArrayList fourSum(int[] arr, int target) {
        HashSet<List<Integer>> set = new HashSet<>();

        if(arr == null || arr.length == 0) return new ArrayList(set);

        int n = arr.length;
        Arrays.sort(arr);
        for(int first = 0; first < n - 3; first++) {
            for(int second = first + 1; second < n - 2; second++) {
                int third = second + 1;
                int fourth = n - 1;

                while(third < fourth) {
                    int sum = arr[first] + arr[second] + arr[third] + arr[fourth];

                    if(sum > target) {
                        fourth--;
                    }
                    else if(sum < target) {
                        third++;
                    }
                    else {
                        set.add(Arrays.asList(arr[first], arr[second], arr[third], arr[fourth]));
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}