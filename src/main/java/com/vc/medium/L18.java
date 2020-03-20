package com.vc.medium;

import java.util.*;

class L18 {

    private int[] arr;

    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(arr == null || arr.length == 0) return list;

        int n = arr.length;
        Arrays.sort(arr);
        for(int first = 0; first < n - 3; first++) {
            if(first > 0 && arr[first - 1] == arr[first]) continue;

            for(int second = first + 1; second < n - 2; second++) {

                if(second > first + 1 && arr[second] == arr[second - 1]) continue;

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
                        list.add(Arrays.asList(arr[first], arr[second], arr[third], arr[fourth]));
                        while(third < fourth && arr[third] == arr[third + 1]) third++;
                        while(third < fourth && arr[fourth] == arr[fourth - 1]) fourth--;
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return list;
    }
}